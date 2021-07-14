package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class feedBack {

	
	@EmbeddedId
	feedBackKey id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id")
    Film filmRefUserInfoRefFB;

    @ManyToOne
    @MapsId("userInfoId")
    @JoinColumn(name = "userInfo_id")
    UserInfo userInfoRefFilmRefFB;
    
    

    //int rating;

}

