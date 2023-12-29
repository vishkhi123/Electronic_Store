package com.electro.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //not for string data type
	private String userId;

	@Column(name="user_name")
	private String name;

	@Column(name="user_email",unique = true)
	private String email;
	
	@Column(name="user_password",length = 15)
	private String password;       

	private String gender;

	@Column(length = 1000)
	private String about; 

	@Column(name="user_image_name")
	private String imageName;


}
