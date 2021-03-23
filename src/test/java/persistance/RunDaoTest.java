package persistance;

import entity.Game;
import entity.Run;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;


public class RunDaoTest {
    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Run.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Run
     */
    @Test
    void getByIdSuccess() {
        Run retrievedRun = (Run)dao.getById(1);
        assertEquals("Normal Mode, Any%", retrievedRun.getCategory());

    }

    /**
     * Verify successful insert of a Run
     */
    @Test
    void insertSuccess() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        GenericDao gameDao = new GenericDao(Game.class);
        GenericDao UserDao = new GenericDao(User.class);

        Game game = (Game)gameDao.getById(1);
        User user = (User)UserDao.getById(1);

        Run newRun = new Run("Normal Mode, Any%", "01:20:32", "PS2", "" + formatter.format(date) + "", "https://www.youtube.com/watch?v=_81rRLpYFBU");
        game.addRun(newRun);
        user.addRun(newRun);
        int id = dao.insert(newRun);
        assertNotEquals(0,id);
        Run insertedRun = (Run)dao.getById(id);
        assertEquals("Normal Mode, Any%", insertedRun.getCategory());
    }

    /**
     * Verify successful update of a Run
     */
    @Test
    void updateSuccess() {
        Run runToUpdate = (Run)dao.getById(2);
        runToUpdate.setPlatform("PS4");
        dao.saveOrUpdate(runToUpdate);
        Run runAfterUpdate = (Run)dao.getById(2);
        assertEquals("PS4", runAfterUpdate.getPlatform());
    }

    /**
     * Verify successful delete of Run
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all Run submissions
     */
    @Test
    void getAllSuccess() {
        List<Run> runs = dao.getAll();
        assertEquals(9, runs.size());
    }
}
