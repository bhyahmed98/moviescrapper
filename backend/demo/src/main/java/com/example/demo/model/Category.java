package com.example.demo.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;

import com.fasterxml.jackson.annotation.JsonIgnore;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import static javax.persistence.TemporalType.TIMESTAMP;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
	@SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
	private long idCategory;
	private String title;
	
	/*
	@ManyToMany
	@JoinTable(name = "CategoFilm",
			joinColumns= @JoinColumn(name="idCategory"),
			inverseJoinColumns = @JoinColumn(name = "idFilm"))


	private Set<Film> films= new HashSet<>();
	*/
	
	
	@OneToMany(mappedBy = "category")
    Set<CategoFilm> categofilm;
	
	
	

}
