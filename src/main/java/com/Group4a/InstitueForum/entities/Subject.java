package com.Group4a.InstitueForum.entities;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="subject")
@Getter
@Setter
public class Subject {
	
	@Id
	private long subject_id;
	private String subject_name;
	private long course_id;
	private String subject_details;
	

}
