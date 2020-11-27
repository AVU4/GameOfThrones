package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Captive;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Services.CaptiveService;
import web.gameofthrones.Services.HeroService;

import java.util.List;

@RestController
public class HeroController {

    @Autowired
    private HeroService heroService;

    @Autowired
    private CaptiveService captiveService;

    @GetMapping("/heroes")
    public List<Hero> getAll(){
        return heroService.getAll();
    }

    @GetMapping("/captives")
    public List<Captive> getAllCaptives(){
        return captiveService.getAll();
    }
}
