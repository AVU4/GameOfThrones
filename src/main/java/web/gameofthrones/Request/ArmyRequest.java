package web.gameofthrones.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ArmyRequest {

    private String name;
    private String nameCountry;
    private String nameHouse;
}
