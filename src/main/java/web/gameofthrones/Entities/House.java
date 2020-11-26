package web.gameofthrones.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "ДОМ")
public class House {

    @Id
    @Column(name="Название")
    private String name;

    @Column(name = "КОЛВО_ЗОЛОТА")
    private long countGold;
}
