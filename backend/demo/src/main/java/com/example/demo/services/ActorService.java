package com.example.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.ActorRepository;
import com.example.demo.model.Actor;



@Service
public class ActorService {
	@Autowired
	private ActorRepository actorRepository;
	
	public List<Actor> getall () {
		return actorRepository.findAll() ; 
	}
	
	public Optional<Actor>  get (long id){
		return actorRepository.findById(id) ; 
	}
	
    public void delete(long id ){
    	actorRepository.deleteById(id);
    }
    
	public Actor Add(Actor actor) {
		return actorRepository.save(actor) ; 
	}
	

	

   

}
