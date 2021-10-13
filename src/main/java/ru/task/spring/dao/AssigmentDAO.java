package ru.task.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.task.spring.models.Assigment;


import java.util.List;

@Component
public class AssigmentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public AssigmentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Assigment> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Assigment p", Assigment.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Assigment show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Assigment.class, id);
    }

    @Transactional
    public void save(Assigment assigment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(assigment);
    }

    @Transactional
    public void update(int id, Assigment updatedAssigment) {
        Session session = sessionFactory.getCurrentSession();
        Assigment assigmentToBeUpdated = session.get(Assigment.class, id);

        assigmentToBeUpdated.setSubjectOfAssigment(updatedAssigment.getSubjectOfAssigment());
        assigmentToBeUpdated.setExecutorsOfAssigment(updatedAssigment.getExecutorsOfAssigment());
        assigmentToBeUpdated.setDateOfExecution(updatedAssigment.getDateOfExecution());
        assigmentToBeUpdated.setSingOfControl(updatedAssigment.getSingOfControl());
        assigmentToBeUpdated.setSingOfExecution(updatedAssigment.getSingOfExecution());
        assigmentToBeUpdated.setTextOfAssigment(updatedAssigment.getTextOfAssigment());
    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Assigment.class, id));
    }
}
