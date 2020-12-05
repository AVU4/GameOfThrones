package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "\"ПЛЕННИК\"")
public class Captive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "\"ИМЯ_ЛИДЕРА\"", foreignKey = @ForeignKey(name = "\"ПЛЕННИК_ИМЯ_ЛИДЕРА_fkey\""))
    private Hero hero;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"НАЗВАНИЕ_ДОМА_ПЛЕНИВШЕГО\"", foreignKey = @ForeignKey(name = "\"ПЛЕННИК_НАЗВАНИЕ_ДОМА_ПЛЕНИВШЕ\""))
    private House houseOwner;




}
