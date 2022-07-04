package com.rustico.ramona.Service.services.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rustico.ramona.Service.dto.ResultUsers;
import com.rustico.ramona.Service.services.interfaces.IUsersCli;

@Service
public class  UsersServices implements IUsersCli {

	@Autowired
    RestTemplate restTemplate;
	private final String uri = "https://jsonplaceholder.typicode.com/users";
	
	@Override
	public List<ResultUsers> usersCli() {

	
		ResponseEntity<ResultUsers[]> response = restTemplate.getForEntity(uri, ResultUsers[].class);
		
		ResultUsers[] usersCliAPI = response.getBody();
		
		List<ResultUsers> resultUser = Arrays.asList(usersCliAPI);
		
		return resultUser;
	}

	public List<ResultUsers> usersXFilter(String filtro){
		List<ResultUsers> result = new ArrayList<>();
		
		for(ResultUsers users : usersCli()) {
			if(users.getEmail().equalsIgnoreCase(filtro)) {
				result.add(users);
			}
		}
		return result;
	}
	
	
	
	
}
