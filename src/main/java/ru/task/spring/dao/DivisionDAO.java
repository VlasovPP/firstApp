package ru.task.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.task.spring.models.Division;

import java.util.List;

@Component
public class DivisionDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public DivisionDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Division> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Division p", Division.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Division show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Division.class, id);
    }

    @Transactional
    public void save(Division division) {
        Session session = sessionFactory.getCurrentSession();
        session.save(division);
    }

    @Transactional
    public void update(int id, Division updatedDivision) {
        Session session = sessionFactory.getCurrentSession();
        Division divisionToBeUpdated = session.get(Division.class, id);

        divisionToBeUpdated.setDivisionName(updatedDivision.getDivisionName());
        divisionToBeUpdated.setContactDetails(updatedDivision.getContactDetails());
        divisionToBeUpdated.setManagerOfDivision(updatedDivision.getManagerOfDivision());
        divisionToBeUpdated.setOrganizationId(updatedDivision.getOrganizationId());

    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Division.class, id));
    }
}
