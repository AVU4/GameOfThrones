package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"ЛИДЕР\"")
public class Hero {

    @Id
    @Column(name = "\"ИМЯ\"")
    private String name;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"НАЗВАНИЕ_ДОМА\"", foreignKey = @ForeignKey( name = "\"ЛИДЕР_НАЗВАНИЯ_ДОМА_fkey\""))
    private House house;

    @Column(name = "\"СИЛА_В_АТАКЕ\"")
    private int forceAttack;

    @Column(name = "\"СИЛА_В_ЗАЩИТЕ\"")
    private int forceDefend;

    @Column(name = "\"БОЕВАЯ_СПОСОБНОСТЬ\"")
    private String skillWar;

    @Column(name = "\"СПОСОБНОСТЬ_В_КАЧЕСТВЕ_КАСТЕЛЯНА\"")
    private String skillCastle;

    @Column(name = "\"РЕЗЕРВИСТ\"")
    private boolean isArrested;

    @OneToOne
    @JoinColumn(name = "\"ПИТОМЕЦ\"", foreignKey = @ForeignKey(name = "\"ЛИДЕР_ПИТОМЕЦ_fkey\""))
    private Pet pet;
}
