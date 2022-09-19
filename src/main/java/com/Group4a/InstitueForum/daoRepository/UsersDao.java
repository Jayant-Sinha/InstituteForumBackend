package com.Group4a.InstitueForum.daoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Group4a.InstitueForum.entities.User;

@Repository
public interface UsersDao extends JpaRepository<User, Long>{

}
