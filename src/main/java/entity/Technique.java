package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Technique.
 */
@Entity(name = "Technique")
@Table(name = "technique")
public class Technique {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int techId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name = "submission_date")
    private String submissionDate;

    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    /**
     * Instantiates a new Technique.
     *
     * @param title          the title
     * @param description    the description
     * @param videoLink      the video link
     * @param submissionDate the submission date
     */
    public Technique(String title, String description, String videoLink, String submissionDate) {
        this.title = title;
        this.description = description;
        this.videoLink = videoLink;
        this.submissionDate = submissionDate;
    }

    public Technique() {

    }

    /**
     * Gets tech id.
     *
     * @return the tech id
     */
    public int getTechId() {
        return techId;
    }

    /**
     * Sets tech id.
     *
     * @param techId the tech id
     */
    public void setTechId(int techId) {
        this.techId = techId;
    }

    /**
     * Gets video link.
     *
     * @return the video link
     */
    public String getVideoLink() {
        return videoLink;
    }

    /**
     * Sets video link.
     *
     * @param videoLink the video link
     */
    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
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
     * Gets submission date.
     *
     * @return the submission date
     */
    public String getSubmissionDate() {
        return submissionDate;
    }

    /**
     * Sets submission date.
     *
     * @param submissionDate the submission date
     */
    public void setSubmissionDate(String submissionDate) {
        this.submissionDate = submissionDate;
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
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
