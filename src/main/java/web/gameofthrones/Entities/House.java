package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
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
    Set<AllianceMember> alliances;

    @JsonBackReference
    @OneToMany(mappedBy = "house", targetEntity = Hero.class)
    Set<Hero> heroes;
}
