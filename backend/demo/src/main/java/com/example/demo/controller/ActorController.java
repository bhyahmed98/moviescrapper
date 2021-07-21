package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Actor;
import com.example.demo.services.ActorService;


import org.springframework.web.bind.annotation.RequestMethod;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("actor")



@RequiredArgsConstructor

public class ActorController {	
    
	@Autowired
    ActorService actorService;
	    
	@PostMapping("/add")
    public Actor saveActor(@RequestBody Actor actor) {
		return actorService.Add(actor) ; 
	}
        
	@GetMapping("/getall")
	public List<Actor> getAllActor(){
		return actorService.getall() ; 
	}
	
	@GetMapping("/get/{id}")
	public Optional<Actor> getActor(@PathVariable("id") long id){
		return actorService.get(id);
	}
	
	@DeleteMapping("delete/{id}")
	public void deleteActor(@PathVariable("id") long id) {
		actorService.delete(id);
	}
	
	




}
