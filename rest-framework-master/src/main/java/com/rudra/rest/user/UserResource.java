package com.rudra.rest.user;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService daoService;
	
	
	@GetMapping("/users")
	public List<User> retrieveAllUsers (){
		return daoService.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User retrieveUser(@PathVariable int  id) {
		return daoService.findOne(id);
	}
	
	@PostMapping("/adduser")
	public void createUser(@RequestBody User user) {
		User savedUser = daoService.save(user);
	}
	
	@PostMapping("/removeuser/{id}")
	public void deleteUser(@PathVariable int id) {
		String message = daoService.deleteUser(id);
	}
	
	@PostMapping("/updateuser")
	public void updateUser(@RequestBody User user) {
		daoService.updateUser(user);
	}
	
}
