package com.mphasis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.entity.User;
import com.mphasis.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/user")
@Tag(name="User Apis", description = "CRUD operations on User")
public class UserController {
	@Autowired
	UserService service;
	
	@GetMapping("/")
	@Operation(summary = "find All Users")
	@ApiResponse(responseCode = "200",description = "Retrive all users info")
	public List<User> findAll()
	{
		return service.findAll();
		
	}
	
	@GetMapping("/{id}")
	@Operation(summary = "find User by Id")
	@ApiResponses({@ApiResponse( responseCode = "200",description = "Addess users info"),
		@ApiResponse(responseCode = "404",description = "User not found")})
	
    public User findById(@PathVariable Long id) {
		
		return service.findById(id);
	}
	
	@Operation(summary = " Users created")
	@ApiResponse(responseCode = "200",description = "User created")
	@PostMapping("/")
	public User save(@Valid @RequestBody User user) {
		
		return service.save(user);
	}
	

}
