package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "\"СРАЖЕНИЕ\"")
public class Battle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "\"НАЗВАНИЕ\"")
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"ЗЕМЛЯ\"")
    private Country country;

    @Column(name = "\"ИТОГ\"")
    private String summary;

    @JsonBackReference
    @OneToMany(mappedBy = "battle", targetEntity = MemberBattle.class)
    private List<MemberBattle> memberBattles;

}
