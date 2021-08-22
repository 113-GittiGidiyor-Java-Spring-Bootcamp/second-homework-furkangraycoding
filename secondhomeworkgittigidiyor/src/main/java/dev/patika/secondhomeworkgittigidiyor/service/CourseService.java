package dev.patika.secondhomeworkgittigidiyor.service;

import dev.patika.secondhomeworkgittigidiyor.dao.CourseDAO;
import dev.patika.secondhomeworkgittigidiyor.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService implements BaseService<Course> {

    private CourseDAO courseDAOJPA;

    @Autowired
    public CourseService(@Qualifier("courseDAOJPAImpl") CourseDAO courseDAOJPA) {
        this.courseDAOJPA = courseDAOJPA;
    }

    @Override
    public List<Course> findAll() {
        return courseDAOJPA.findAll();
    }

    @Override
    public Course findById(int id) {
        return (Course) courseDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Course save(Course course) {

        return (Course) courseDAOJPA.save(course);

    }

    @Override
    public void deleteById(int id) {

    }
}
