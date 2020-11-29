package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name ="\"АРМИЯ\"")
public class Army {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "\"ЛИДЕР\"")
    private Hero general;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "\"ЗЕМЛЯ\"")
    private Country country;

    @Column(name = "\"БОЕВАЯ_МОЩЬ\"")
    private int force;

    @JsonBackReference
    @OneToMany(mappedBy = "army", targetEntity = MemberBattle.class)
    private List<MemberBattle> memberBattles;

    @JsonManagedReference
    @OneToMany(mappedBy = "army", targetEntity = Squad.class)
    private List<Squad> squadList;




}
