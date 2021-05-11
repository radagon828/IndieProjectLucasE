package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Run.
 */
@Entity(name = "Run")
@Table(name = "run")
public class Run {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "time")
    private String time;

    @Column(name = "platform")
    private String platform;

    @Column(name = "date")
    private String date;

    @Column(name = "video_link")
    private String videoLink;

    @Column(name= "approval")
    private String approval;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="run_category_id")
    private RunCategory category;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    /**
     * Instantiates a new Run.
     *
     * @param time      the time
     * @param platform  the platform
     * @param date      the date
     * @param videoLink the video link
     */
    public Run( String time, String platform, String date, String videoLink, String approval) {
        this.time = time;
        this.platform = platform;
        this.date = date;
        this.videoLink = videoLink;
        this.approval = approval;
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
    public RunCategory getCategory() {
        return category;
    }

    /**
     * Sets category.
     *
     * @param category the category
     */
    public void setCategory(RunCategory category) {
        this.category = category;
    }

    /**
     * Gets time.
     *
     * @return the time
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets time.
     *
     * @param time the time
     */
    public void setTime(String time) {
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

    /**
     * Gets approval.
     *
     * @return the approval
     */
    public String getApproval() {
        return approval;
    }

    /**
     * Sets approval.
     *
     * @param approval the approval
     */
    public void setApproval(String approval) {
        this.approval = approval;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Run run = (Run) o;
        return id == run.id && Objects.equals(time, run.time) && Objects.equals(platform, run.platform) && Objects.equals(date, run.date) && Objects.equals(videoLink, run.videoLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, platform, date, videoLink);
    }

    @Override
    public String toString() {
        return "Run{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", time='" + time + '\'' +
                ", platform='" + platform + '\'' +
                ", date='" + date + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }

}