package entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * The type Game.
 *
 * @author Lucas Eddy
 */
@Entity(name = "Game")
@Table(name = "game")
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

    @JsonManagedReference
    @OneToMany(mappedBy = "game", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<RunCategory> categories;

    @JsonManagedReference
    @OneToMany(mappedBy = "game", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Run> runs;

    @JsonManagedReference
    @OneToMany(mappedBy = "game", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
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

    /**
     * Gets categories.
     *
     * @return the categories
     */
    public Set<RunCategory> getCategories() {
        return categories;
    }

    /**
     * Sets categories.
     *
     * @param categories the categories
     */
    public void setCategories(Set<RunCategory> categories) {
        this.categories = categories;
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
     * Remove run.
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

    /**
     * Add category.
     *
     * @param category the category
     */
    public void addCategory(RunCategory category) {
        categories.add(category);
        category.setGame(this);
    }

    /**
     * Remove category.
     *
     * @param category the category
     */
    public void removeCategory(RunCategory category) {
        categories.remove(category);
        category.setGame(null);
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
     * @param game_id the game id
     */
    public void setId(int game_id) {
        this.id = game_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Objects.equals(title, game.title) && Objects.equals(description, game.description) && Objects.equals(imagePth, game.imagePth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, imagePth);
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", imagePth='" + imagePth + '\'' +
                '}';
    }
}
