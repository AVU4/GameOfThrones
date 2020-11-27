package web.gameofthrones.Entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
@Table(name = "\"УЧАСТНИК_СОЮЗА\"")
public class AllianceMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"ДОМ\"", foreignKey = @ForeignKey(name = "УЧАСТНИК_СОЮЗА_ДОМ_fkey"))
    private House house;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "\"НАЗВАНИЕ_СОЮЗА\"", foreignKey = @ForeignKey(name = "УЧАСТНИК_СОЮЗА_НАЗВАНИЕ_СОЮЗА_fkey"))
    private Alliance alliance;
}
