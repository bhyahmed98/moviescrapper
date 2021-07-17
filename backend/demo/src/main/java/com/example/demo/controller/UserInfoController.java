package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List; 
import com.example.demo.model.UserInfo;
import com.example.demo.services.UserInfoService;

@RestController
@RequestMapping("/user")

public class UserInfoController {
	@Autowired
	UserInfoService userService;
	
	@GetMapping("/user")
	private List<UserInfo> getAllUserInfo()
	
	{	return userService.getAllUserInfo();
		}
	
	@GetMapping("/user/{userid}")
	private UserInfo getUser(@PathVariable("userid)") Long userid)
	{
		return userService.getUserById(userid);
	}
	@DeleteMapping("/user/{userid}")
	private void deleteUser(@PathVariable("userid") Long userid)
	{	userService.deleteUser(userid)
		;}
	@PostMapping("/user")
	private void addUser(@RequestBody UserInfo user)
	{	userService.addUser(user)
		;}
}
