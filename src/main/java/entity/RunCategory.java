package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

/**
 * The type Run category.
 */
@Entity(name = "RunCategory")
@Table(name = "run_category")
public class RunCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_name_con")
    private String categoryNameCon;

    @Column(name= "category_rules")
    private String categoryRules;

    @Column(name= "approval")
    private int 0;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @JsonManagedReference
    @OneToMany(mappedBy = "category", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Run> runs;

    /**
     * Instantiates a new Run category.
     */
    public RunCategory() {
    }

    /**
     * Instantiates a new Run category.
     *
     * @param categoryName    the category name
     * @param categoryNameCon the category name con
     * @param categoryRules   the category rules
     */
    public RunCategory(String categoryName, String categoryNameCon, String categoryRules) {
        this.categoryName = categoryName;
        this.categoryNameCon = categoryNameCon;
        this.categoryRules = categoryRules;
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
     * Gets category name.
     *
     * @return the category name
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets category name.
     *
     * @param categoryName the category name
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets category rules.
     *
     * @return the category rules
     */
    public String getCategoryRules() {
        return categoryRules;
    }

    /**
     * Sets category rules.
     *
     * @param categoryRules the category rules
     */
    public void setCategoryRules(String categoryRules) {
        this.categoryRules = categoryRules;
    }

    /**
     * Gets game.
     *
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Sets game.
     *
     * @param game the game
     */
    public void setGame(Game game) {
        this.game = game;
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
     * Add run.
     *
     * @param run the run
     */
    public void addRun(Run run) {
        runs.add(run);
        run.setCategory(this);
    }

    /**
     * Remove run
     *
     * @param run the run
     */
    public void removeRun(Run run) {
        runs.remove(run);
        run.setCategory(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RunCategory category = (RunCategory) o;
        return Objects.equals(categoryName, category.categoryName) && Objects.equals(categoryNameCon, category.categoryNameCon) && Objects.equals(categoryRules, category.categoryRules);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName, categoryNameCon, categoryRules);
    }

    @Override
    public String toString() {
        return "RunCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryNameCon='" + categoryNameCon + '\'' +
                ", categoryRules='" + categoryRules + '\'' +
                '}';
    }

    /**
     * Gets category name con.
     *
     * @return the category name con
     */
    public String getCategoryNameCon() {
        return categoryNameCon;
    }

    /**
     * Sets category name con.
     *
     * @param categoryNameCon the category name con
     */
    public void setCategoryNameCon(String categoryNameCon) {
        this.categoryNameCon = categoryNameCon;
    }
}
