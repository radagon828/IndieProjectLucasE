package persistance;


import entity.Game;
import entity.Run;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GameDaoTest {

    GameDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        dao = new GameDao();
    }

    /**
     * Verify successful retrieval of a Game
     */
    @Test
    void getByIdSuccess() {
        Game retrievedGame = dao.getById(1);
        assertEquals("Haunting Ground", retrievedGame.getTitle());

    }

    /**
     * Verify successful insert of a Game
     */
    @Test
    void insertSuccess() {
        Game newGame = new Game( "Resident Evil 2(1998)", "Developed By Capcom", "imgpath");
        int id = dao.insert(newGame);
        assertNotEquals(0,id);
        Game insertedGame = dao.getById(id);
        assertEquals("Resident Evil 2(1998)", insertedGame.getTitle());
    }

    /**
     * Verify successful update of a Game
     */
    @Test
    void updateSuccess() {
        Game gameToUpdate = dao.getById(2);
        gameToUpdate.setDescription("Not Developed By Capcom");
        dao.saveOrUpdate(gameToUpdate);
        Game gameAfterUpdate = dao.getById(2);
        assertEquals("Not Developed By Capcom", gameAfterUpdate.getDescription());
    }

    /**
     * Verify successful delete of Game
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * verify that a run with the deleted gameId was deleted
     */
    @Test
    void cascadeDeleteSuccess() {
        RunDao runDao = new RunDao();
        Run run = runDao.getById(1);
        dao.delete(dao.getById(5));
        assertNull(dao.getById(5));
        assertNull(run);
    }
    /**
     * Verify successful retrieval of all games
     */
    @Test
    void getAllSuccess() {
        List<Game> games = dao.getAll();
        assertEquals(5, games.size());
    }
}