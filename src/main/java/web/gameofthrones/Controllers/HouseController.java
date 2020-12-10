package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.gameofthrones.Entities.*;
import web.gameofthrones.Request.CaptiveRequest;
import web.gameofthrones.Services.*;
import web.gameofthrones.util.ProcessOfBuying;

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

    @Autowired
    private ProcessOfBuying process;

    @GetMapping("/house")
    public ResponseEntity<House> getHouse(@RequestParam("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        House home =  houseService.getOneByName(house);
        houseService.refresh(home);
        return new ResponseEntity<>(home, HttpStatus.OK);
    }

    @GetMapping("/countries")
    public ResponseEntity<List<Country>> getAllCountriesInHouse(@RequestParam ("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(countryService.getAllInHouse(house), HttpStatus.OK);
    }

    @GetMapping("/castles")
    public ResponseEntity<List<Castle>>  getAllCastlesInHouse(@RequestParam ("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(castleService.getAllInHouse(house), HttpStatus.OK);
    }

    @GetMapping("/captives")
    public ResponseEntity<List<Captive>> getAllCaptivesInHouse(@RequestParam ("house") String house) {
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(captiveService.getAllInHouse(house), HttpStatus.OK);
    }

    @GetMapping("/heroes")
    public ResponseEntity<List<Hero>> getAllFromHouse(@RequestParam("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(heroService.getAllInHouse(house), HttpStatus.OK);
    }

    @GetMapping("/reserve")
    public ResponseEntity<List<Hero>> getAllReservesFromHouse(@RequestParam("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(heroService.getAllFromReserveInHouse(house), HttpStatus.OK);
    }

    @GetMapping("/othercaptives")
    public ResponseEntity<List<Captive>> getAllCaptivesFromOtherHouse(@RequestParam("house") String house) {
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(captiveService.getAllFromOtherHouse(house), HttpStatus.OK);
    }

    @PostMapping("/captive")
    public ResponseEntity<Long> buyCaptive(@RequestBody CaptiveRequest captiveRequest){
        String name = captiveRequest.getName();
        String result = process.buyCaptive(name);
        if (result.equals("No ok")) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(houseService.getOneByHeroName(name).getCountGold(), HttpStatus.OK);
    }
}
