package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Battle;
import web.gameofthrones.Services.BattleService;

import java.util.List;

@CrossOrigin
@RestController
public class HistoryController {

    @Autowired
    private BattleService battleService;

    @GetMapping("/history")
    public List<Battle> getBattles(){
        return battleService.getAll();
    }
}
