package dev.patika.secondhomeworkgittigidiyor.dao;

import dev.patika.secondhomeworkgittigidiyor.model.Instructor;
import dev.patika.secondhomeworkgittigidiyor.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class InstructorDAOJPAImpl implements InstructorDAO<Instructor> {

    private EntityManager entityManager;
    @Autowired
    public InstructorDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Instructor> findAll() {
        return entityManager.createQuery("select s from Instructor s",Instructor.class).getResultList();
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public Instructor save(Instructor instructor) {

        return entityManager.merge(instructor);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Instructor instructor = this.findById(id);

        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public Instructor update(Instructor instructor) {
        return entityManager.merge(instructor);
    }
}
