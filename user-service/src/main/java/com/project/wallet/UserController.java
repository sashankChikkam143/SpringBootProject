package com.project.wallet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public User reateUser(@RequestBody UserCreate usercreate)
	{
		return userService.create(usercreate);
	}
	
	
	@GetMapping("/get")
	public User getUser(@RequestParam("id") int id)
	{
		return userService.getUser(id);
	}

}
