package com.example.demo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Personnel;
import com.example.demo.entity.Role;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

import com.example.demo.request.LoginRequest;
import com.example.demo.request.SignupRequest;

import com.example.demo.response.JwtResponse;
import com.example.demo.response.MessageResponse;
import com.example.demo.security.jwt.JwtUtils;
import com.example.demo.security.service.UserDetailsImpl;
import com.example.demo.security.service.UserDetailsServiceImpl;

import io.jsonwebtoken.Jwts;



@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/auth")
public class Auth {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;
  
 
  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser( @RequestBody LoginRequest loginRequest) {

    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getMatriculeP(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    
    
    
    List<String> role = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
      .collect(Collectors.toList());
      
    
      /* Role role = userDetails.getAuthorities().stream()
            .map(authority -> new Role(authority.getAuthority()))
            .findFirst()
            .orElse(null);

 */ 
    return ResponseEntity.ok(new JwtResponse(
    		userDetails.getIdP(),jwt, 
                         "Bearer",
                         userDetails.getEmail(),
                         userDetails.getMatriculeP(),
                         userDetails.getNom(),
                         userDetails.getPrenom(),
                         userDetails.getTel(),
                         userDetails.getPoste(),
                          userDetails.getPassword(),
                          userDetails.getAdresse(),
                          userDetails.getDate_embauche(),
                          userDetails.getDate_naissance(),
                          userDetails.getEtat_civile(),
                          userDetails.getNombre_enfants(),
                          userDetails.getNotes(),
                          userDetails.getSexe(),
                          userDetails.getService(),
                          role));
  }
 
 @PostMapping("/signup")
  public ResponseEntity<Personnel> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
	 String mat = generateNewPassword();
	 signUpRequest.setMatriculeP(mat);
	 System.out.println(mat);
	 signUpRequest.setMatriculeP(mat);
	 System.out.println(mat);
	 
	 /*
		 * if (userRepository.existsByMatricule(signUpRequest.getMatricule())) { return
		 * ResponseEntity .badRequest() .body(new
		 * MessageResponse("Error: Username is already taken!")); }
		 */

	
/*	  if (userRepository.existsByEmail(signUpRequest.getEmail())) { return
	  ResponseEntity .badRequest() .body(new
	  MessageResponse("Error: Email is already in use!")); }
	*/ 
    //Create new user's account
    Personnel user = new Personnel( 
    		
    		signUpRequest.getEmail(),
    		signUpRequest.genererMatricule(),
    		signUpRequest.getNom(),
    		signUpRequest.getPrenom(),
    		signUpRequest.getTel(),
    		signUpRequest.getPoste(),
            encoder.encode(signUpRequest.getPassword()),
            signUpRequest.getAdresse(),
            signUpRequest.getDate_embauche(),
            signUpRequest.getDate_naissance(),
            signUpRequest.getEtat_civile(),
            signUpRequest.getNombre_enfants(),
            signUpRequest.getNotes(),
            signUpRequest.getService(),
            signUpRequest.getSexe()
          
            
            );
    
    
    
    	int intRole = signUpRequest.getRole();
    	Role userrole = roleRepository.findById(intRole)
                .orElseThrow(() -> new RuntimeException("Error: not found."));
    	
    	user.setRole(userrole);
    	
    

 /*   Integer intRoles = signUpRequest.getRoles();
    Set<Role> roles = new HashSet<>();
    Role userRole = roleRepository.findById(intRoles)
            .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
       roles.add(userRole);*/
		/*
//		 * if (strRoles == null) { Role userRole =
//		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } else {
//		 * strRoles.forEach(role -> { switch (role) { case "admin": Role adminRole =
//		 * roleRepository.findByName(ERole.ROLE_ADMIN) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(adminRole);
//		 * 
//		 * break; case "mod": Role modRole =
//		 * roleRepository.findByName(ERole.ROLE_MODERATOR) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(modRole); break;
//		 * case "rh": Role rhRole = roleRepository.findByName(ERole.ROLE_RH)
//		 * .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
//		 * roles.add(rhRole); break; default: Role userRole =
//		 * roleRepository.findByName(ERole.ROLE_USER) .orElseThrow(() -> new
//		 * RuntimeException("Error: Role is not found.")); roles.add(userRole); } }); }
//		 */
//
    //user.setRoles(roles);
    userRepository.save(user);
    return ResponseEntity.ok(user);
    
  }

 private String generateNewPassword() {
	 int length = 10; // Set the desired length of the password
	    boolean useLetters = true; // Use letters (a-z, A-Z) in the password
	    boolean useNumbers = true; // Use numbers (0-9) in the password
	    return JwtUtils.random(length, useLetters, useNumbers);
 

 }}


