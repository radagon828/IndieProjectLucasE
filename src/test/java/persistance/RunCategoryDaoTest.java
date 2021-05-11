package persistance;

import entity.Game;
import entity.Run;
import entity.RunCategory;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import javax.sql.rowset.CachedRowSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Run category dao test.
 *
 * @author Lucas Eddy
 */
public class RunCategoryDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(RunCategory.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Run Category
     */
    @Test
    void getByIdSuccess() {
        RunCategory retrievedCat = (RunCategory)dao.getById(1);
        assertEquals("A Ending, New Game", retrievedCat.getCategoryName());
    }

    /**
     * Verify successful insert of a Run Category
     */
    @Test
    void insertSuccess() {
        GenericDao gameDao = new GenericDao(Game.class);

        Game game = (Game)gameDao.getById(1);

        RunCategory newCategory = new RunCategory("Ending E", "endinge", "<p>Reach the final ending</p>");
        game.addCategory(newCategory);

        int id = dao.insert(newCategory);
        assertNotEquals(0,id);
        RunCategory insertedCategory = (RunCategory) dao.getById(id);


        assertEquals(newCategory, insertedCategory);
    }

    /**
     * Verify successful update of a Run Category
     */
    @Test
    void updateSuccess() {
        RunCategory categoryToUpdate = (RunCategory) dao.getById(2);
        categoryToUpdate.setCategoryName("New Name");
        dao.saveOrUpdate(categoryToUpdate);
        RunCategory categoryAfterUpdate = (RunCategory) dao.getById(2);
        assertEquals(categoryToUpdate, categoryAfterUpdate);
    }

    /**
     * Verify successful delete of Run Category
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * Verify successful retrieval of all Run Categories
     */
    @Test
    void getAllSuccess() {
        List<RunCategory> categories = dao.getAll();
        assertEquals(13, categories.size());
    }
}
