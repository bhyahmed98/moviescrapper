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
@Table(name = "userInfo")
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq")
	private long idUser;
	private String name;
	private String email;
	private String password;
	private String phonenumber;

	@OneToMany(mappedBy = "userInfoRefFilmRefFav")
	Set<favourite> fav;

	@OneToMany(mappedBy = "userInfoRefFilmRefFB")
	Set<feedBack> fb;

}
