package com.genspark.RESTFulAssignment.Service;

import com.genspark.RESTFulAssignment.Entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();
    Course getCourseById(int courseId);
    Course addCourse(Course course);
    Course updateCourse(Course course);
    String deleteCourseById(int courseId);

}
