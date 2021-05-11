package persistance;

import entity.Game;
import entity.Run;
import entity.RunCategory;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * The type Run dao test.
 *
 * @author Lucas Eddy
 */
public class RunDaoTest {

    /**
     * The Dao.
     */
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
        assertEquals("Normal Mode", retrievedRun.getCategory().getCategoryName());

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
        GenericDao CategoryDao = new GenericDao(RunCategory.class);

        Game game = (Game)gameDao.getById(1);
        User user = (User)UserDao.getById(1);
        RunCategory category = (RunCategory)CategoryDao.getById(2);



        Run newRun = new Run("01:20:32", "PS2", "" + formatter.format(date)
                + "", "https://www.youtube.com/watch?v=_81rRLpYFBU", "0");
        game.addRun(newRun);
        user.addRun(newRun);
        category.addRun(newRun);
        int id = dao.insert(newRun);
        assertNotEquals(0,id);
        Run insertedRun = (Run)dao.getById(id);
        System.out.println(newRun.getVideoLink());
        assertEquals(newRun , insertedRun);
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
        assertEquals(runToUpdate, runAfterUpdate);
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
