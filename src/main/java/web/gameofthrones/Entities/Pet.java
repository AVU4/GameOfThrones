package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table( name = "\"ПИТОМЕЦ\"")
public class Pet {

    @Id
    @Column(name = "\"КЛИЧКА\"")
    private String name;

    @Column(name = "\"СИЛА\"")
    private int force;

    @Column(name = "\"СПОСОБНОСТЬ\"")
    private String skill;

    @JsonBackReference
    @OneToOne(mappedBy = "pet")
    private Hero heroOwner;

}
