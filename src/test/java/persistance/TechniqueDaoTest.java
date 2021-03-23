package persistance;

import entity.Game;
import entity.Run;
import entity.Technique;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechniqueDaoTest {
    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Technique.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Technique
     */
    @Test
    void getByIdSuccess() {
        Technique retrievedTech = (Technique)dao.getById(1);
        assertEquals("Haunting Ground Commentary", retrievedTech.getTitle());

    }

    /**
     * Verify successful insert of a Technique
     */
    @Test
    void insertSuccess() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        GenericDao gameDao = new GenericDao(Game.class);
        GenericDao UserDao = new GenericDao(User.class);

        Game game = (Game)gameDao.getById(1);
        User user = (User)UserDao.getById(1);

        Technique newTech = new Technique("Resident Evil Remake Commentary", "This video is a commentated run of REmake", "https://www.youtube.com/watch?v=N-TrW-LN7Xw", "" + formatter.format(date) + "");
        game.addTechnique(newTech);
        user.addTechnique(newTech);
        int id = dao.insert(newTech);
        assertNotEquals(0,id);
        Technique insertedTech = (Technique)dao.getById(id);
        assertEquals("Resident Evil Remake Commentary", insertedTech.getTitle());
    }

    /**
     * Verify successful update of a Technique
     */
    @Test
    void updateSuccess() {
        Technique techToUpdate = (Technique)dao.getById(2);
        techToUpdate.setTitle("New Title");
        dao.saveOrUpdate(techToUpdate);
        Technique techAfterUpdate = (Technique)dao.getById(2);
        assertEquals(techToUpdate, techAfterUpdate);
    }

    /**
     * Verify successful delete of Technique
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
    }

    /**
     * Verify successful retrieval of all tech video submissions
     */
    @Test
    void getAllSuccess() {
        List<Technique> techniques = dao.getAll();
        assertEquals(2, techniques.size());
    }
}
