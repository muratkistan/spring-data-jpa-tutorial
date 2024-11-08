package com.muratkistan.spring.data.jpa.tutorial.repository;

import com.muratkistan.spring.data.jpa.tutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Long> {
}
