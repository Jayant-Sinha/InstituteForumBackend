package com.Group4a.InstitueForum.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="role_id")
	private long role_id;
	
	@Column(name="role_name")
	private String role_name;
	
	
//	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "user_id", referencedColumnName ="id")
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = User.class, mappedBy = "role")
	private List<User> user;
	

	public Role() {

		// TODO Auto-generated constructor stub
	}


	public long getRole_id() {
		return role_id;
	}


	public void setRole_id(long role_id) {
		this.role_id = role_id;
	}


	public String getRole_name() {
		return role_name;
	}


	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


	public List<User> getUser() {
		return user;
	}


	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
	
}
