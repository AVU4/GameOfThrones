package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"ИСТОРИЯ\"")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "КОРОЛЬ")
    private Hero king;

    @Column(name = "\"ГОД_НАЧАЛА_ПРАВЛЕНИЯ\"")
    private String dateStart;

    @Column(name = "\"ГОД_ОКОНЧАНИЯ_ПРАВЛЕНИЯ\"")
    private String dateEnd;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "\"ГЛАВЕНСТВУЮЩИЙ_ДОМ\"")
    private House house;

}
