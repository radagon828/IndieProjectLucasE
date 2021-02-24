package persistance;

import entity.Game;
import entity.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class RunDao {
    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get run by id
     */
    public Run getById(int id) {
        Session session = sessionFactory.openSession();
        Run run = session.get( Run.class, id );
        session.close();
        return run;
    }

    /**
     * update run
     * @param run
     */
    public void saveOrUpdate(Run run) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(run);
        transaction.commit();
        session.close();
    }

    /**
     * insert run
     * @param run
     */
    public int insert(Run run) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(run);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a run
     * @param run Run to be deleted
     */
    public void delete(Run run) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(run);
        transaction.commit();
        session.close();
    }

    /** Return a list of all the runs
     *
     * @return All submitted runs
     */
    public List<Run> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Run> query = builder.createQuery( Run.class );
        Root<Run> root = query.from( Run.class );
        List<Run> runs = session.createQuery( query ).getResultList();

        logger.debug("The list of submitted runs " + runs);
        session.close();

        return runs;
    }
}
