package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "User")
@Table(name = "user")
public class User {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Run> runs;

    @OneToMany(mappedBy = "user", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Technique> techniques;

    /**
     * instantiates a user class
     */
    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
