package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.gameofthrones.Entities.Captive;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Services.CaptiveService;
import web.gameofthrones.Services.HeroService;

import java.util.List;

@CrossOrigin
@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private CaptiveService captiveService;

    @GetMapping("/heroes")
    public List<Hero> getAllFromHouse(@RequestParam("house") String house){
        return heroService.getAllInHouse(house);
    }

    @GetMapping("/captives")
    public List<Captive> getAllCaptives(){
        return captiveService.getAll();
    }
}
