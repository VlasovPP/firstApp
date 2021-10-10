package ru.task.spring.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.task.spring.models.Organization;
import java.util.List;

@Component
public class OrganizationDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public OrganizationDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional(readOnly = true)
    public List<Organization> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from Organization p", Organization.class)
                .getResultList();
    }

    @Transactional(readOnly = true)
    public Organization show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Organization.class, id);
    }


    @Transactional
    public void save(Organization organization) {
        Session session = sessionFactory.getCurrentSession();
        session.save(organization);
    }

    @Transactional
    public void update(int id, Organization updatedOrganization) {
        Session session = sessionFactory.getCurrentSession();
        Organization organizationToBeUpdated = session.get(Organization.class, id);

        organizationToBeUpdated.setNameOfOrganization(updatedOrganization.getNameOfOrganization());
        organizationToBeUpdated.setPhysicalAddress(updatedOrganization.getPhysicalAddress());
        organizationToBeUpdated.setLegalAddress(updatedOrganization.getLegalAddress());
        organizationToBeUpdated.setNameOfDirector(updatedOrganization.getNameOfDirector());

    }

    @Transactional
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(Organization.class, id));
    }
}

