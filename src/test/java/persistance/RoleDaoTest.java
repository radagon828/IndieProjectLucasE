package persistance;

import entity.Role;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import testUtils.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleDaoTest {
    GenericDao dao;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        dao = new GenericDao(Role.class);

        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verify successful retrieval of a Role
     */
    @Test
    void getByIdSuccess() {
        Role retrievedRole = (Role)dao.getById(2);
        assertEquals("sonic", retrievedRole.getUser_name());

    }

    /**
     * Verify successful insert of a Role
     */
    @Test
    void insertSuccess() {
        GenericDao userDao = new GenericDao(User.class);

        User user = (User)userDao.getById(3);

        Role role = new Role("user", "darkflash");

        user.addRole(role);

        int id = dao.insert(role);
        assertNotEquals(0,id);
        Role insertedRole = (Role)dao.getById(id);
        assertEquals(role, insertedRole);
    }

    /**
     * Verify successful update of a Role
     */
    @Test
    void updateSuccess() {
        Role roleToUpdate = (Role)dao.getById(2);
        roleToUpdate.setRoleName("User");
        dao.saveOrUpdate(roleToUpdate);
        Role roleAfterUpdate = (Role)dao.getById(2);
        assertEquals(roleToUpdate, roleAfterUpdate);
    }

    /**
     * Verify successful delete of Role
     */
    @Test
    void deleteSuccess() {
        dao.delete(dao.getById(1));
        assertNull(dao.getById(1));
    }

    /**
     * Verify successful retrieval of all roles
     */
    @Test
    void getAllSuccess() {
        List<Role> roles = dao.getAll();
        assertEquals(2, roles.size());
    }
}
