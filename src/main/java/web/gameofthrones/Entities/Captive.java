package web.gameofthrones.Entities;

import javax.persistence.*;

@Entity
@Table(name = "\"ПЛЕННИК\"")
public class Captive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "\"ИМЯ_ЛИДЕРА\"", foreignKey = @ForeignKey(name = "\"ПЛЕННИК_ИМЯ_ЛИДЕРА_fkey\""))
    private Hero hero;

    @OneToOne
    @JoinColumn(name = "\"НАЗВАНИЕ_ДОМА_ПЛЕНИВШЕГО\"", foreignKey = @ForeignKey(name = "\"ПЛЕННИК_НАЗВАНИЕ_ДОМА_ПЛЕНИВШЕ\""))
    private House house;
}
