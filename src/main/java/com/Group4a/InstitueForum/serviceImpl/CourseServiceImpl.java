package com.Group4a.InstitueForum.serviceImpl;

import com.Group4a.InstitueForum.daoRepository.CourseDao;
import com.Group4a.InstitueForum.entities.Course;
import com.Group4a.InstitueForum.entities.Subject;
import com.Group4a.InstitueForum.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    @Override
    public void addCourse(Course course) {
        courseDao.save(course);
    }

    @Override
    public Course getCourseById(long id) throws Exception {
        Course course = courseDao.findCourseById(id);
        if(course == null) {
            throw new Exception("No Course found with Id: " + id);
        }
        return course;
    }
}
