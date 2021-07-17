package com.example.demo.services;


import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;  

@Service

public class UserInfoService {
	
	@Autowired
	
	private UserInfoRepository userRepository;
	
	public List<UserInfo> getAllUserInfo()
	{
		return userRepository.findAll();
		
	}
	
	public UserInfo getUserById( Long id )
	{	return userRepository.findById(id).get()
		;}
	
	public void addUser(UserInfo user)
	{	userRepository.save(user)
		;}
	public void deleteUser(Long UserId)
	{	userRepository.deleteById(UserId)
		;}


	
;}
