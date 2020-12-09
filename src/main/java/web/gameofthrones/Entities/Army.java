package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    private Integer force;

    @JsonBackReference
    @OneToMany(mappedBy = "army", targetEntity = MemberBattle.class)
    private List<MemberBattle> memberBattles;

    @JsonManagedReference
    @OneToMany(mappedBy = "army", targetEntity = Squad.class)
    private List<Squad> squadList;


    public Army(Hero hero, Country country){
        this.general = hero;
        this.country = country;
        this.force = 0;
    }



}
