package persistance;
import entity.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 * @author Lucas Eddy
 */
public class GenericDao<T> {
    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Session factory.
     */
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    /**
     * The Builder.
     */
    CriteriaBuilder builder;

    /**
     * Instantiates a new Generic Dao.
     *
     * @param type the entity type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Get entity by id
     *
     * @param <T> the type parameter
     * @param id  entity to search by
     * @return an entity
     */
    public <T>T getById(int id) {
        logger.info("grabbing object from: " + type);
        Session session = getSession();
        T entity = (T)session.get( type, id );
        session.close();
        return entity;
    }


    /**
     * update entity
     *
     * @param entity the entity
     */
    public void saveOrUpdate(T entity) {
        logger.info("updating from: " + type);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        session.close();
    }

    /**
     * insert entity
     *
     * @param entity the entity
     * @return the int
     */
    public int insert(T entity) {
        logger.info("inserting into: " + type);
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete an entity
     *
     * @param entity entity to be deleted
     */
    public void delete(T entity) {
        logger.info("deleting from: " + type);
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Return a list of all the entities
     *
     * @return All entities
     */
    public List<T> getAll() {
        Session session = getSession();

        logger.info("Getting all of an entity: " + type);

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;
    }

    /**
     * Gets by string.
     *
     * @param propertyName the property name
     * @param searchWord   the search word
     * @return the by string
     */
    public List<T> getByString(String propertyName, String searchWord) {
        Session session = getSession();

        logger.info("Search for a game based on: " + searchWord);

        builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);

        query.select(root).where(builder.like(root.get(propertyName), "%" + searchWord + "%"));
        List<T> list = session.createQuery(query).getResultList();

        session.close();
        return list;
    }


    /**
     * Returns an open session from session factory
     * @return session
     */
    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


}
