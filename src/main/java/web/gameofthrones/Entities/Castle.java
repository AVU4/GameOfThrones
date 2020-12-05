package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="\"ЗАМОК\"")
public class Castle {

    @Id
    @Column(name = "\"НАЗВАНИЕ\"")
    private String name;

    @Column(name = "\"ОСОБЕННОСТЬ_РАСПОЛОЖЕНИЯ\"")
    private String uniqueCondition;

    @Column(name = "\"ОБОРОННАЯ_МОЩЬ\"")
    private int forceDefense;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "НАЗВАНИЕ_ЗЕМЛИ")
    private Country country;
}
