package com.example.demo.model;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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

	@OneToMany(mappedBy = "actRefFilm")
	Set<ActFilm> actFilm;

}
