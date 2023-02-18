package pl.coderslab.bankaccount.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.bankaccount.entity.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager em;

    public void save(Person entity) {
        em.persist(entity);
    }


    public void delete(Person entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findAllWithBankTransfers() {
        return em.createQuery("SELECT DISTINCT p FROM Person p LEFT JOIN FETCH p.bankTransfers", Person.class).getResultList();
    }
}