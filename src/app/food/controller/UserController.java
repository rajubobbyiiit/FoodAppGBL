package app.food.controller;

import app.food.service.UserService;

public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	public String addUser(){
		return userService.addUser();
	}
	
	
}
 
