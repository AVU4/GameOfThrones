package web.gameofthrones.Request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SquadRequest {

    private Integer number;
    private Integer armyId;
    private String type;
    private String house;
}
