package dev.patika.secondhomeworkgittigidiyor.dao;

import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class StudentDAOHibernateImpl implements StudentDAO<Student>{


    private EntityManager entityManager;

    @Autowired
    public StudentDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> findAll() {
        Session session= entityManager.unwrap(Session.class);

        return session.createQuery("from Student ",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return null;
    }

    @Override
    public Student save(Student student) {
        Session session= entityManager.unwrap(Session.class);
        return (Student) session.merge(student);
    }

    @Override
    public void deleteById(int id) {

    }
}
