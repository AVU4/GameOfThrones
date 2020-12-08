package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.gameofthrones.Entities.*;
import web.gameofthrones.Services.*;

import java.util.List;

@CrossOrigin
@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CastleService castleService;

    @Autowired
    private CaptiveService captiveService;

    @Autowired
    private HeroService heroService;

    @GetMapping("/house")
    public House getHouse(@RequestParam("house") String house){

        House home =  houseService.getOneByName(house);
        houseService.refresh(home);
        return home;
    }

    @GetMapping("/countries")
    public List<Country> getAllCountriesInHouse(@RequestParam ("house") String house){
        System.out.println(house);
        return countryService.getAllInHouse(house);
    }

    @GetMapping("/castles")
    public List<Castle>  getAllCastlesInHouse(@RequestParam ("house") String house){
        return castleService.getAllInHouse(house);
    }

    @GetMapping("/captives")
    public List<Captive> getAllCaptivesInHouse(@RequestParam ("house") String house) {
        System.out.println(house);
        return captiveService.getAllInHouse(house);
    }

    @GetMapping("/heroes")
    public List<Hero> getAllFromHouse(@RequestParam("house") String house){
        return heroService.getAllInHouse(house);
    }

}
