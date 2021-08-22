package dev.patika.secondhomeworkgittigidiyor.service;

import dev.patika.secondhomeworkgittigidiyor.dao.StudentDAO;
import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService implements BaseService<Student> {

    private StudentDAO studentDAOJPA;

    @Autowired
    public StudentService(@Qualifier("studentDAOHibernateImpl") StudentDAO studentDAOJPA) {
        this.studentDAOJPA = studentDAOJPA;
    }

    @Override
    public List<Student> findAll() {
        return studentDAOJPA.findAll();
    }

    @Override
    public Student findById(int id) {
        return (Student) studentDAOJPA.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {

        return (Student) studentDAOJPA.save(student);

    }

    @Override
    public void deleteById(int id) {

    }
}
