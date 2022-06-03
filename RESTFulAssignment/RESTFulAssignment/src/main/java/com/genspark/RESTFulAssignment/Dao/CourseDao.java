package com.genspark.RESTFulAssignment.Dao;

import com.genspark.RESTFulAssignment.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
}
