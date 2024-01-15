package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ERole;
import com.example.demo.entity.Role;



public interface RoleRepository extends JpaRepository <Role, Integer>{
	 Optional<Role> findByNomRole(ERole name);

}