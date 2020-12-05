package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Castle;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.CastleService;
import web.gameofthrones.Services.CountryService;
import web.gameofthrones.Services.HouseService;

import javax.websocket.server.PathParam;
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
    private ArmyService armyService;

    @GetMapping("/house")
    public House getHouse(@RequestParam("house") String house){
        return houseService.getOneByName(house);
    }


    @GetMapping("/houses")
    public List<House> getAll(){
        return houseService.getAll();
    }

    @GetMapping("/countries")
    public List<Country> getAllCountriesInHouse(@RequestParam ("house") String house){
        System.out.println(house);
        return countryService.getAllInHouse(house);
    }

    @GetMapping("/castles")
    public List<Castle>  getAllCastlesInHouse(@RequestParam ("house") String house){
        System.out.println(house);
        return castleService.getAllInHouse(house);
    }

    @GetMapping("/armies")
    public List<Army> getAllArmies(){return armyService.getAll();}
}
