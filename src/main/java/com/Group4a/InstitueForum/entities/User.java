package com.Group4a.InstitueForum.entities;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="user")
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="id")
	private long id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "user_name", unique = true)
	private String userName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@ManyToOne( cascade = CascadeType.ALL)
	@JoinColumn(name = "roles_id", referencedColumnName ="role_id")
	private Role role;

	@ManyToMany
	private List<Course> course;

}
