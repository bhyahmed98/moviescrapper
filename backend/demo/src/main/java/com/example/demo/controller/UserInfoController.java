package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Actor;
import com.example.demo.model.UserInfo;
import com.example.demo.services.ActorService;
import com.example.demo.services.UserInfoService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("user")



@RequiredArgsConstructor

public class UserInfoController {	
    
	@Autowired
	UserInfoService userInfoService;
	    
    @PostMapping("/add")
    public UserInfo saveUserInfo(@RequestBody UserInfo userInfo) {
		return userInfoService.AddUserInfo(userInfo); 
	}
        
	@GetMapping("/getall")
	public List<UserInfo> getAllUserInfo(){
		return userInfoService.getallUserInfo();
	}
	
	@GetMapping("/get/{id}")
	public Optional<UserInfo> getUserInfo(@PathVariable("id") long id){
		return userInfoService.getUserInfo(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteActor(@PathVariable("id") long id) {
		userInfoService.delete(id);
	}
	
	




}
