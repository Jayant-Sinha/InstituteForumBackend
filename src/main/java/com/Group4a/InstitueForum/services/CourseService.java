package com.Group4a.InstitueForum.services;

import com.Group4a.InstitueForum.entities.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {

    public List<Course> getAllCourses();
//    public List<Course> getAllCoursesByUserId(long userId);

    void addCourse(Course course);

    Course getCourseById(long id) throws Exception;

//    void addUserToCourse(long userId, long courseId);
}
