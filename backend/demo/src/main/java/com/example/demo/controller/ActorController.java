package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Actor;
import com.example.demo.services.ActorService;


import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class ActorController {
    @Autowired
    ActorService actorService;
	
    
    @GetMapping("/addActor")
	public String Addproduct(Model model) {
        Actor a = new Actor();
        model.addAttribute("actor", a);
        return "addproduct";
    }
    
	@GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable("id") long id, Model model) {

        actorService.delete(id);
        return "redirect:/product";
    }
	
	@GetMapping("/getall")
	public List<Actor> getAllActor(){
		return actorService.getallActor() ; 
	}
	
	

}
