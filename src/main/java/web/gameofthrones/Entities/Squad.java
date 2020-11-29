package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"ОТРЯД\"")
public class Squad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "\"id_АРМИИ\"")
    private Army army;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"РОДНОЙ_ДОМ\"")
    private House house;

    @Column(name = "\"ТИП_ОТРЯДА\"")
    private String type;

    @Column(name = "\"ЧИСЛЕННОСТЬ\"")
    private int numberSoldiers;

    @Column(name = "\"БОЕВАЯ_МОЩЬ_ЕДИНИЦЫ\"")
    private int forcePerSoldier;

    @Column(name = "\"БОЕВАЯ_МОЩЬ\"")
    private int force;
}
