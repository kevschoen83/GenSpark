package com.genspark.RESTFulAssignment.Service;

import com.genspark.RESTFulAssignment.Dao.CourseDao;
import com.genspark.RESTFulAssignment.Entity.Course;
import com.genspark.RESTFulAssignment.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourseById(int courseId) {
        Optional<Course> c = this.courseDao.findById(courseId);
        Course course = null;

        if (c.isPresent()) {
            course = c.get();
        } else {
            throw new RuntimeException(" Course not found for id :: " + courseId);
        }

        return course;
    }

    @Override
    public Course addCourse(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return this.courseDao.save(course);
    }

    @Override
    public String deleteCourseById(int courseId) {
        this.courseDao.deleteById(courseId);
        return "Course deleted successfully!";
    }

}
