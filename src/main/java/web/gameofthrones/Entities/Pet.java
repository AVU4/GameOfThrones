package web.gameofthrones.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

}
