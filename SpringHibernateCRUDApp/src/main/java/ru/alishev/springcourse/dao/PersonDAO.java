package ru.alishev.springcourse.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.alishev.springcourse.models.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Component
@Repository
public class PersonDAO {

    @PersistenceContext
    private EntityManager entityManager;

//    private final SessionFactory sessionFactory;
//
//    @Autowired
//    public PersonDAO(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

//    @Transactional(readOnly = true)
//    public List<Person> index() {
//        Session session = sessionFactory.getCurrentSession();
//
//        return session.createQuery("select p from Person p", Person.class)
//                .getResultList();
//    }
    @Transactional(readOnly = true)
    public List<Person> index() {
       // Session session = sessionFactory.getCurrentSession();

    return entityManager.createQuery("select p from Person p", Person.class)
                .getResultList();
    }
//

//    @Transactional(readOnly = true)
//    public Person show(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        return session.get(Person.class, id);
//    }

    @Transactional(readOnly = true)
    public Person show(int id) {
        //Session session = sessionFactory.getCurrentSession();
        return entityManager.find(Person.class, id);
    }

//    @Transactional
//    public void save(Person person) {
//        Session session = sessionFactory.getCurrentSession();
//        session.save(person);
//    }

    @Transactional
    public void save(Person person) {
       // Session session = sessionFactory.getCurrentSession();
        entityManager.persist(person);
    }

//    @Transactional
//    public void update(int id, Person updatedPerson) {
//        Session session = sessionFactory.getCurrentSession();
//        Person personToBeUpdated = session.get(Person.class, id);
//
//        personToBeUpdated.setName(updatedPerson.getName());
//        personToBeUpdated.setAge(updatedPerson.getAge());
//        personToBeUpdated.setEmail(updatedPerson.getEmail());
//    }
@Transactional
public void update(int id, Person updatedPerson) {
   // Session session = sessionFactory.getCurrentSession();
    Person personToBeUpdated = entityManager.find(Person.class, id);

    personToBeUpdated.setName(updatedPerson.getName());
    personToBeUpdated.setAge(updatedPerson.getAge());
    personToBeUpdated.setEmail(updatedPerson.getEmail());
}

//    @Transactional
//    public void delete(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        session.remove(session.get(Person.class, id));
//    }

    @Transactional
    public void delete(int id) {
       // Session session = sessionFactory.getCurrentSession();
        entityManager.remove(entityManager.find(Person.class, id));
    }
}
