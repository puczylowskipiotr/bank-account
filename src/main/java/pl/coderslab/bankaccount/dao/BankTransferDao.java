package pl.coderslab.bankaccount.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.bankaccount.entity.BankTransfer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BankTransferDao {

    @PersistenceContext
    EntityManager em;

    public void save(BankTransfer entity) {
        em.persist(entity);
    }

    public void update(BankTransfer entity) {
        em.merge(entity);
    }

    public void delete(BankTransfer entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
    }


    public List<BankTransfer> findAll() {
        TypedQuery<BankTransfer> query = em.createQuery("SELECT b FROM BankTransfer b", BankTransfer.class);
        List<BankTransfer> results = query.getResultList();

        return results;
    }


}
