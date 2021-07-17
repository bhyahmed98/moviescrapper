package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Film;
import com.example.demo.repository.FilmRepository;

@Service
public class FilmService {

 	
 	@Autowired
	private FilmRepository filmRepository;
	
	public List<Film> getallFilm () {
		return filmRepository.findAll() ; 
	}
	
	public Optional<Film>  getFilm (long id){
		return filmRepository.findById(id) ; 
	}
	
    public void delete(long id ){
    	filmRepository.deleteById(id);
    }
    
	public Film AddFilm(Film film) {
		return filmRepository.save(film) ; 
	}
	
	


}
