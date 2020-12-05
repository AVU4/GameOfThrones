package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"ЗЕМЛЯ\"")
public class Country {

    @Id
    @Column(name = "\"НАЗВАНИЕ\"")
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"НАЗВАНИЕ_ДОМА\"")
    private House houseOwner;

    @Column(name = "\"КОЛИЧЕСТВО_КРЕСТЬЯН\"")
    private long countPeasants;

    @JsonBackReference
    @OneToOne(mappedBy = "country", targetEntity = Castle.class)
    private Castle castle;

    @JsonBackReference
    @OneToOne(mappedBy = "country", targetEntity = Army.class)
    private Army army;

    @JsonBackReference
    @OneToMany(mappedBy = "country", targetEntity = Battle.class)
    private Set<Battle> battles;

}
