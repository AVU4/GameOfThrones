package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Battle>> getBattles(){
        return new ResponseEntity<>(battleService.getAll(), HttpStatus.OK);
    }
}
