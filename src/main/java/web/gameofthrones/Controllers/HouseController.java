package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.CountryService;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private ArmyService armyService;

    @GetMapping("/houses")
    public List<House> getAll(){
        return houseService.getAll();
    }


    @GetMapping("/countries")
    public List<Country> getAllCountries(){return countryService.getAll();}

    @GetMapping("/armies")
    public List<Army> getAllArmies(){return armyService.getAll();}
}
