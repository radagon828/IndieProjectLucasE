package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Run.
 */
public class Run {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "category")
    private String category;

    @Column(name = "time")
    private double time;

    @Column(name = "platform")
    private String platform;

    @Column(name = "date")
    private String date;

    @Column(name = "video_link")
    private String videoLink;

    @ManyToOne
    private Game game;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new Run.
     *
     * @param category  the category
     * @param time      the time
     * @param platform  the platform
     * @param date      the date
     * @param videoLink the video link
     * @param game      the game
     */
    public Run(String category, double time, String platform, String date, String videoLink, Game game) {
        this.category = category;
        this.time = time;
        this.platform = platform;
        this.date = date;
        this.videoLink = videoLink;
        this.game = game;
    }

    /**
     * Instantiates a new Run.
     */
    public Run() {

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
     * Gets category.
     *
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public double getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(double time) {
        this.time = time;
    }

    /**
     * Gets platform.
     *
     * @return the platform
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * Sets platform.
     *
     * @param platform the platform
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(String date) {
        this.date = date;
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