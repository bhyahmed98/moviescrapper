package com.example.demo.model;



import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import lombok.Data;

@Data
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "admin")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "admin_seq")
	@SequenceGenerator(name = "admin_seq", sequenceName = "admin_seq")
	private long idAdmin;
	private String email;
	private String password;
	


}
