package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "Film_seq")
	@SequenceGenerator(name = "Film_seq", sequenceName = "Film_seq")
	private long idFilm;
	private String nameFilm;
	private int idCategory;
	private int year;
	private String language;
	private int numRate;
	private int curRate;

	
	// public Product(@JsonProperty("id")Long id,
	// @JsonProperty("description")String description,
	// @JsonProperty("created_at")Date created_at,
	// @JsonProperty("price")float price,
	// @JsonProperty("stock")float stock,
	// @JsonProperty("brand")String brand) {
	// super();
	// this.id = id;
	// this.description = description;
	// this.created_at = created_at;
	// this.price = price;
	// this.stock = stock;
	// this.brand = brand;
	// }

	// @Column(name = "name", nullable = false)
	// private String name;
	//
	// @Column(name = "madeIn", nullable = false)
	// private String madeIn;

	// public Article(@JsonProperty("idArticle") int idArticle,
	// @JsonProperty("nameArticle") String nameArticle,
	// @JsonProperty("couleur") String couleur,
	// @JsonProperty("taille") int taille,
	// @JsonProperty("qte") int qte,
	// @JsonProperty("prix") float prix,
	// @JsonProperty("prixT") float prixT,
	// String urlimage) {
	// this.idArticle = idArticle;
	// this.nameArticle = nameArticle;
	// this.couleur = couleur;
	// this.taille = taille;
	// this.qte = qte;
	// this.prix = prix;
	// this.prixT = prixT;
	// this.urlimage = urlimage;

}
