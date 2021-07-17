package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Actor;
import com.example.demo.model.UserInfo;
import com.example.demo.repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public List<UserInfo> getallUserInfo () {
		return userInfoRepository.findAll() ; 
	}
	
	public Optional<UserInfo>  getUserInfo (long id){
		return userInfoRepository.findById(id) ; 
	}
	
    public void delete(long id ){
    	userInfoRepository.deleteById(id);
    }
    
	public UserInfo AddUserInfo(UserInfo userInfo) {
		return userInfoRepository.save(userInfo) ; 
	}


	

	

   

}