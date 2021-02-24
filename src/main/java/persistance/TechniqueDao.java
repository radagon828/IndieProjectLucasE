package persistance;

import entity.Technique;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TechniqueDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get technique by id
     */
    public Technique getById(int id) {
        Session session = sessionFactory.openSession();
        Technique technique = session.get( Technique.class, id );
        session.close();
        return technique;
    }

    /**
     * update technique
     * @param technique
     */
    public void saveOrUpdate(Technique technique) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(technique);
        transaction.commit();
        session.close();
    }

    /**
     * insert Technique
     * @param technique
     */
    public int insert(Technique technique) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(technique);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a technique
     * @param technique Technique to be deleted
     */
    public void delete(Technique technique) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(technique);
        transaction.commit();
        session.close();
    }

    /** Return a list of all the techniques
     *
     * @return All techniques
     */
    public List<Technique> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Technique> query = builder.createQuery( Technique.class );
        Root<Technique> root = query.from( Technique.class );
        List<Technique> techniques = session.createQuery( query ).getResultList();

        logger.debug("The list of Technique submissions " + techniques);
        session.close();

        return techniques;
    }
}
