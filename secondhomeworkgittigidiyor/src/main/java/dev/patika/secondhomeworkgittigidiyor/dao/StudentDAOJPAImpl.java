package dev.patika.secondhomeworkgittigidiyor.dao;

import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class StudentDAOJPAImpl implements StudentDAO<Student> {

    private EntityManager entityManager;
    @Autowired
    public StudentDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("select s from Student s",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public Student save(Student student) {

        return entityManager.merge(student);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Student student = this.findById(id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }
}
