package com.example.demo.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "actor")
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actor_seq")
	@SequenceGenerator(name = "actor_seq", sequenceName = "actor_seq")
	private long idActor;
	private String nameActor;
	
	// this.urlimage = urlimage;
	
	@OneToMany(mappedBy = "actRefFilm")
    Set<ActFilm> actFilm;

}
