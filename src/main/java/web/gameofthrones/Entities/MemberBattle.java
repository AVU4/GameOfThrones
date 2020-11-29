package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"УЧАСТНИК_СРАЖЕНИЯ\"")
public class MemberBattle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"id_АРМИИ\"")
    private Army army;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"ДОМ\"")
    private House house;

    @Column(name = "\"КОЛИЧЕСТВО_УБИТЫХ\"")
    private int countDied;

    @Column(name = "\"КОЛИЧЕСТВО_УЦЕЛЕВШИХ\"")
    private int countSaved;

    @Column(name = "\"КОЛИЧЕСТВО_ПРЕДАТЕЛЕЙ\"")
    private int countBetrayed;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"id_СРАЖЕНИЯ\"")
    private Battle battle;
}
