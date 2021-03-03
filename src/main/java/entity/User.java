package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "User", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Run> runs;

    @OneToMany(mappedBy = "User", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Technique> techniques;

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

    /**
     * Add run.
     *
     * @param run the run
     */
    public void addRun(Run run) {
        runs.add(run);
        run.setUser(this);
    }

    /**
     * Remove book.
     *
     * @param run the run
     */
    public void removeRun(Run run) {
        runs.remove(run);
        run.setUser(null);
    }

    /**
     * Add technique.
     *
     * @param technique the technique
     */
    public void addTechnique(Technique technique) {
        techniques.add(technique);
        technique.setUser(this);
    }

    /**
     * Remove technique.
     *
     * @param technique the technique
     */
    public void removeTechnique(Technique technique) {
        techniques.remove(technique);
        technique.setUser(null);
    }
}
