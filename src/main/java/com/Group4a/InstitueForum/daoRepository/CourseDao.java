package com.Group4a.InstitueForum.daoRepository;

import com.Group4a.InstitueForum.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Long> {

    public Course findCourseById(long id);
}
