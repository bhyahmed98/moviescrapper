package com.example.demo.model;


import java.util.Set;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "Film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Film_seq")
	@SequenceGenerator(name = "Film_seq", sequenceName = "Film_seq")
	private long idFilm;
	private String nameFilm;
	private int idCategory;
	private int year;
	private String language;


	@OneToMany(mappedBy = "filmRefCat")
	Set<CategoFilm> categoFilm;

	@OneToMany(mappedBy = "filmRefAct")
	Set<ActFilm> actFilm;

	@OneToMany(mappedBy = "filmRefUserInfoRefFav")
	Set<favourite> fav;

	@OneToMany(mappedBy = "filmRefUserInfoRefFB")
	Set<feedBack> fb;

}
