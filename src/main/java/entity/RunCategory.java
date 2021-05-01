package entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "RunCategory")
@Table(name = "runCategory")
public class RunCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "category_name")
    private String categoryName;

    @Column(name= "category_rules")
    private Long categoryRules;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="game_id")
    private Game game;
}
