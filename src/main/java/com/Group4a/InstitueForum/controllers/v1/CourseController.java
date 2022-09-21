package com.Group4a.InstitueForum.controllers.v1;

import com.Group4a.InstitueForum.entities.Course;
import com.Group4a.InstitueForum.services.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/v1")
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses =  courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<List<Course>> addCourse(@RequestBody Course course) {
        try {
            courseService.addCourse(course);
            List<Course> courses =  courseService.getAllCourses();
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCoursById(@PathVariable long id) {
        Course course = null;
        try {
            course = courseService.getCourseById(id);
            return new ResponseEntity<>(course, HttpStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new ResponseEntity<>(course, HttpStatus.BAD_REQUEST);
        }
    }
}
