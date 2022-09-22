package com.Group4a.InstitueForum.controllers.v1;

import com.Group4a.InstitueForum.entities.Course;
import com.Group4a.InstitueForum.entities.Subject;
import com.Group4a.InstitueForum.services.CourseService;
import com.Group4a.InstitueForum.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class SubjectController {
    
//    @Autowired
//    CourseService courseService;
//
//    @Autowired
//    UserService userService;
//
//    @PostMapping("/user/{id}/courses/{course_id}/subject")
//    public ResponseEntity<List<Course>> addCourseToUser(@RequestBody Subject subject,
//                                                        @PathVariable String course_id,
//                                                        @PathVariable String id) {
//
//
//        long userId = Long.parseLong(id);
//        long courseId = Long.parseLong(course_id);
//        try {
//            courseService.addUserToCourse(userId, courseId);
//            List<Course> courses =  courseService.getAllCoursesByUserId(userId);
//            return new ResponseEntity<>(courses, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//
//    @GetMapping("/user/{id}/courses")
//    public ResponseEntity<List<Course>> getCourseForUser(@PathVariable String id) {
//        try {
//            long userId = Long.parseLong(id);
//            courseService.getAllCoursesByUserId(userId);
//            List<Course> courses =  courseService.getAllCourses();
//            return new ResponseEntity<>(courses, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
}
