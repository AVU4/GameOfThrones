package web.gameofthrones.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BattleRequest {

    private String houseName;
    private String countryName;
    private Integer armyId;
}
