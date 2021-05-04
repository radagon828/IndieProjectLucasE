package persistance;

import entity.Game;
import entity.Run;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class GameDaoTest {

    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Game.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Game
     */
    @Test
    void getByIdSuccess() {
        Game retrievedGame = (Game)dao.getById(1);
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
        Game insertedGame = (Game)dao.getById(id);
        assertEquals("Resident Evil 2(1998)", insertedGame.getTitle());
        assertEquals("Developed By Capcom", insertedGame.getDescription());
        assertEquals("imgpath", insertedGame.getImagePth());
    }

    /**
     * Verify successful update of a Game
     */
    @Test
    void updateSuccess() {
        Game gameToUpdate = (Game)dao.getById(2);
        gameToUpdate.setDescription("Not Developed By Capcom");
        dao.saveOrUpdate(gameToUpdate);
        Game gameAfterUpdate = (Game)dao.getById(2);
        assertEquals(gameToUpdate, gameAfterUpdate);
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
        GenericDao runDao = new GenericDao(Run.class);
        dao.delete(dao.getById(4));
        assertNull(dao.getById(4));
        assertNull(runDao.getById(1));
    }
    /**
     * Verify successful retrieval of all games
     */
    @Test
    void getAllSuccess() {
        List<Game> games = dao.getAll();
        assertEquals(4, games.size());
    }

    @Test
    void getByTitleSuccess() {
        String value = "haunt";
        List<Game> games = dao.getByString("title",value);
        System.out.println(games);
    }


}
