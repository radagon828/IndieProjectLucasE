package persistance;


import entity.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//  remember to test that books can be added when adding an author
// test that when an author is deleted, all associated books are deleted
public class GameDaoTest {

    GameDao dao;

    /**
     * Run set up tasks before each test:
     * 1. execute sql which deletes everything from the table and inserts records)
     * 2. Create any objects needed in the tests
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
        Game newAuthor= new Author( "Lucas", "Eddy");
        int id = dao.insert(newAuthor);
        assertNotEquals(0,id);
        Author insertedAuthor = dao.getById(id);
        assertEquals("Lucas", insertedAuthor.getFirstName());
    }

    /**
     * Verify successful update of a Book
     */
    @Test
    void updateSuccess() {
//        String author = "John Smith";
        Author authorToUpdate = dao.getById(2);
        authorToUpdate.setFirstName("John");
        dao.saveOrUpdate(authorToUpdate);
        Author authorAfterUpdate = dao.getById(2);
        assertEquals("John", authorAfterUpdate.getFirstName());
    }

    /**
     * Verify successful delete of Book
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(3));
        assertNull(dao.getById(3));
    }

    /**
     * verify that a book with the deleted author id was deleted
     */
    @Test
    void cascadeDeleteSuccess() {
        BookDao bookDao = new BookDao();
        Book book = bookDao.getById(2);
        dao.delete(dao.getById(2));
        assertNull(dao.getById(2));
        assertNull(bookDao.getById(3));
    }
    /**
     * Verify successful retrieval of all authors
     */
    @Test
    void getAllSuccess() {
        List<Author> authors = dao.getAll();
        assertEquals(3, authors.size());
    }
}
