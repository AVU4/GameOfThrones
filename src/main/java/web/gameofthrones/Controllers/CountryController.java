package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Country>> getAllFreeCountry(@RequestParam("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(countryService.getAllFreeCountry(house), HttpStatus.OK);
    }

    @GetMapping("/enemycountry")
    public ResponseEntity<List<Country>> getAllEnemyCountry(@RequestParam("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(countryService.getEnemyCountry(house), HttpStatus.OK);
    }
}
