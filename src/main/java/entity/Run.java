package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * The type Run.
 */
public class Run {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    private int gameId;

    @Column(name = "category")
    private String category;

    private int userId;

    @Column(name = "time")
    private double time;

    @Column(name = "platform")
    private String platform;

    @Column(name = "date")
    private String date;

    @Column(name = "video_link")
    private String videoLink;

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
     * Gets gameId.
     *
     * @return the gameId
     */
    public int getGameId() {
        return gameId;
    }

    /**
     * Sets game.
     *
     * @param gameId the game
     */
    public void setGame(int gameId) {
        this.gameId = gameId;
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
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Sets user id.
     *
     * @param userId the user id
     */
    public void setUserId(int userId) {
        this.userId = userId;
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



}