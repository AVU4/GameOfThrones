package web.gameofthrones.Responces;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import web.gameofthrones.Entities.Army;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BattleResponse{
    private String result;
    private List<Army> army;
}
