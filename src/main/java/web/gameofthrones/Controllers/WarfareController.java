package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Services.ArmyService;

import java.util.List;

@CrossOrigin
@RestController
public class WarfareController {

    @Autowired
    private ArmyService armyService;

    @GetMapping("/armies")
    public List<Army>  getAllInHouse(@RequestParam("house") String house){
        return armyService.getAllInHouse(house);
    }
}
