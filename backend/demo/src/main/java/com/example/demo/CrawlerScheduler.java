package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.example.demo.model.Actor;
import com.example.demo.repository.ActorRepository;


@Component
@EnableScheduling

public class CrawlerScheduler
{  	@Autowired
	ActorRepository actrepActorRepository;
	@Bean
	@Scheduled(fixedDelay=3000)
    
	public void scheduleFixedRateTask() {
	    Actor actor=new Actor();
	    actor.setNameActor("Fethi Haddaoui");
	    actrepActorRepository.save(actor);
	    
	}
}
