package com.Group4a.InstitueForum.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="course")
@Data
public class Course {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, targetEntity = Subject.class, mappedBy = "course")
    private List<Subject> subjects;

}
