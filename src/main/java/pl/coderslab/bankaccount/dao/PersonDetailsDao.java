package pl.coderslab.bankaccount.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.bankaccount.entity.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager em;

    public void save(PersonDetails entity) {
        em.persist(entity);
    }

    public void update(PersonDetails entity) {
        em.merge(entity);
    }

    public void delete(PersonDetails entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }

    public PersonDetails findById(Long id) {
        return em.find(PersonDetails.class, id);
    }
}
