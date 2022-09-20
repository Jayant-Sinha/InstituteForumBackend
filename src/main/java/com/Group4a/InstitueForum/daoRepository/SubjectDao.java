package com.Group4a.InstitueForum.daoRepository;

import com.Group4a.InstitueForum.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository<Subject, Long> {

    public Subject findSubjectById(long id);
}
