package persistance;


import entity.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class GameDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get game by id
     */
    public Game getById(int id) {
        Session session = sessionFactory.openSession();
        Game game = session.get( Game.class, id );
        session.close();
        return game;
    }

    /**
     * update game
     * @param game
     */
    public void saveOrUpdate(Game game) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(game);
        transaction.commit();
        session.close();
    }

    /**
     * insert game
     * @param game
     */
    public int insert(Game game) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int)session.save(game);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Delete a game
     * @param game Game to be deleted
     */
    public void delete(Game game) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(game);
        transaction.commit();
        session.close();
    }

    /** Return a list of all the users
     *
     * @return All games
     */
    public List<Game> getAll() {

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Game> query = builder.createQuery( Game.class );
        Root<Game> root = query.from( Game.class );
        List<Game> games = session.createQuery( query ).getResultList();

        logger.debug("The list of games " + games);
        session.close();

        return games;
    }
}
