package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Services.CountryService;

import java.util.List;

@CrossOrigin
@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/freecountry")
    public List<Country> getAllFreeCountry(@RequestParam("house") String house){
        return countryService.getAllFreeCountry(house);
    }

    @GetMapping("/enemycountry")
    public List<Country> getAllEnemyCountry(@RequestParam("house") String house){
        return countryService.getEnemyCountry(house);
    }
}
