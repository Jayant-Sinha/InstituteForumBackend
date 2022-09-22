package com.Group4a.InstitueForum.daoRepository;

import com.Group4a.InstitueForum.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group4a.InstitueForum.entities.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersDao extends JpaRepository<User, Long>{

//    public User findUsersById(long id);
    Optional<User> findUserByUserName(String username);
    List<User> findUsersByCourse(String courseId);
//    Boolean existsByUsername(String username);
//    Boolean existsByEmail(String email);
}
