package persistance;


import controller.MD5Digest;
import entity.Role;
import entity.Run;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type User dao test.
 *
 * @author Lucas Eddy
 */
public class UserDaoTest {

    /**
     * The Dao.
     */
    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(User.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Game
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)dao.getById(1);
        assertEquals("sonic", retrievedUser.getUserName());
    }
    @Test
    void testStringConversion() throws Exception {
        MD5Digest theObject = new MD5Digest();
        theObject.convertString("11111");
    }
    /**
     * Verify successful insert of a Game
     */
    @Test
    void insertSuccess() {
        User newUser = new User( "myNewEmail@email.com", "newUser34", "12345");
        Role role = new Role("user", newUser.getUserName());
        newUser.addRole(role);

        int id = dao.insert(newUser);
        assertNotEquals(0,id);

        User insertedUser = (User)dao.getById(id);
        assertEquals(newUser, insertedUser);

    }

    /**
     * Verify successful update of a Game
     */
    @Test
    void updateSuccess() {
        User userToUpdate = (User)dao.getById(2);
        userToUpdate.setUserName("bigman6000");
        dao.saveOrUpdate(userToUpdate);
        User userAfterUpdate = (User)dao.getById(2);
        assertEquals(userToUpdate, userAfterUpdate);
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
        dao.delete(dao.getById(5));
        assertNull(dao.getById(5));
        assertNull(runDao.getById(8));
    }

    /**
     * Verify successful retrieval of all games
     */
    @Test
    void getAllSuccess() {
        List<User> users = dao.getAll();
        assertEquals(5, users.size());
    }

    /**
     * Gets user success.
     */
    @Test
    void getUserSuccess() {
        List<User> user = dao.getByString("userName", "carci");
        System.out.println(user.get(0));
    }

    /**
     * Gets user success.
     */
    @Test
    void getNewPass() throws Exception {
        MD5Digest pass = new MD5Digest();
        String newPass = pass.convertString("test1");

        System.out.println(newPass);
    }

}
