package web.gameofthrones.Entities;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "\"СОЮЗ\"")
public class Alliance {

    @Id
    @Column(name = "\"НАЗВАНИЕ\"")
    private String name;

    @Column(name = "\"ДАТА_ОБРАЗОВАНИЯ\"", nullable = false)
    private String dateStart;

    @Column(name = "\"ДАТА_ОКОНЧАНИЯ\"")
    private String dataEnd;

    @JsonBackReference
    @OneToMany(mappedBy = "alliance")
    private Set<AllianceMember> members;

}
