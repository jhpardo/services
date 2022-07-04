package com.rustico.ramona.Service.controller;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rustico.ramona.Service.dto.ResultUsers;
import com.rustico.ramona.Service.services.impl.UsersServices;

@RestController
@RequestMapping("/api/users")
public class UsersController {
	
	@Autowired
	UsersServices userService;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ResultUsers> getAllProducts(@QueryParam("email") String email) {
		
		List<ResultUsers> users = null;
		if(email != null && email.length() > 0) {
			users = userService.usersXFilter(email);
		} else {
			users = userService.usersCli();
		}
		
		System.out.println("Usuarios" + users.size());
		return users;
	}

}
