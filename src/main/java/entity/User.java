package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    /**
     * instantiates a user class
     */
    public User() {

    }

    /**
     * returns the value of the user's id
     * @return userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * sets the value of the user id
     * @param userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * returns the value of the username
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * sets the value of the username
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * returns the value of the password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}