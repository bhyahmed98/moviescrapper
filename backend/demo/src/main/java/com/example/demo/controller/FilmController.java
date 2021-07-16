package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Actor;
import com.example.demo.model.Film;
import com.example.demo.services.ActorService;
import com.example.demo.services.FilmService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class FilmController {
    @Autowired
    FilmService filmService;
	
    
    @GetMapping("/addFilm")
	public String Addproduct(Model model) {
        Film f = new Film();
        model.addAttribute("film", f);
        return "addfilm";
    }
    
	@GetMapping("/deleteFilm/{id}")
    public String deleteFilm(@PathVariable("id") long id, Model model) {

        filmService.delete(id);
        return "redirect:/film";
    }
	
	@GetMapping("/getall")
	public List<Film> getAllFilm(){
		return filmService.getallFilm() ; 
	}
	
	

}
