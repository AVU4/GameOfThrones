package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "\"ДОМ\"")
public class House {

    public House() {
    }

    @Id
    @Column(name="\"НАЗВАНИЕ\"")
    private String name;

    @Column(name = "\"КОЛВО_ЗОЛОТА\"")
    private long countGold;

    @JsonBackReference
    @OneToMany(mappedBy = "house")
    private Set<AllianceMember> alliances;

    @JsonBackReference
    @OneToMany(mappedBy = "house", targetEntity = Hero.class)
    private Set<Hero> heroes;

    @JsonBackReference
    @OneToMany(mappedBy = "houseOwner", targetEntity = Captive.class)
    private Set<Captive> captives;

    @JsonBackReference
    @OneToMany(mappedBy = "houseOwner", targetEntity = Country.class)
    private Set<Country> countries;


    @JsonBackReference
    @OneToMany(mappedBy = "house", targetEntity = Squad.class)
    private List<Squad> squadList;

    @JsonBackReference
    @OneToMany(mappedBy = "house", targetEntity = MemberBattle.class)
    private List<MemberBattle> memberBattles;

    @JsonBackReference
    @OneToOne(mappedBy = "house", targetEntity = History.class)
    private History history;


}
