package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * The type Game.
 */
public class Game {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "image_pth")
    private String imagePth;

    /**
     * Gets runs.
     *
     * @return the runs
     */
    public Set<Run> getRuns() {
        return runs;
    }

    /**
     * Sets runs.
     *
     * @param runs the runs
     */
    public void setRuns(Set<Run> runs) {
        this.runs = runs;
    }

    /**
     * Gets techniques.
     *
     * @return the techniques
     */
    public Set<Technique> getTechniques() {
        return techniques;
    }

    /**
     * Sets techniques.
     *
     * @param techniques the techniques
     */
    public void setTechniques(Set<Technique> techniques) {
        this.techniques = techniques;
    }

    @OneToMany(mappedBy = "Game", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Run> runs;

    @OneToMany(mappedBy = "Game", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Technique> techniques;

    /**
     * Instantiates a new Game.
     */
    public Game() {

    }

    /**
     * Instantiates a new Game.
     *
     * @param title       the title
     * @param description the description
     * @param imagePth    the image pth
     */
    public Game (String title, String description, String imagePth) {
        this.title = title;
        this.description = description;
        this.imagePth = imagePth;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets image pth.
     *
     * @return the image pth
     */
    public String getImagePth() {
        return imagePth;
    }

    /**
     * Sets image pth.
     *
     * @param imagePth the image pth
     */
    public void setImagePth(String imagePth) {
        this.imagePth = imagePth;
    }

    /**
     * Add run.
     *
     * @param run the run
     */
    public void addRun(Run run) {
        runs.add(run);
        run.setGame(this);
    }

    /**
     * Remove book.
     *
     * @param run the run
     */
    public void removeRun(Run run) {
        runs.remove(run);
        run.setGame(null);
    }

    /**
     * Add technique.
     *
     * @param technique the technique
     */
    public void addTechnique(Technique technique) {
        techniques.add(technique);
        technique.setGame(this);
    }

    /**
     * Remove technique.
     *
     * @param technique the technique
     */
    public void removeTechnique(Technique technique) {
        techniques.remove(technique);
        technique.setGame(null);
    }
}
