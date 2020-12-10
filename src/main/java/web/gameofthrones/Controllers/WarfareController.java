package web.gameofthrones.Controllers;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Entities.Squad;
import web.gameofthrones.Request.ArmyRequest;
import web.gameofthrones.Request.BattleRequest;
import web.gameofthrones.Request.SquadRequest;
import web.gameofthrones.Responces.BattleResponse;
import web.gameofthrones.Responces.TypeSquadResponse;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.HouseService;
import web.gameofthrones.util.BattleProcess;
import web.gameofthrones.util.ProcessOfBuying;
import web.gameofthrones.util.TypeSquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class WarfareController {

    @Autowired
    private ArmyService armyService;

    @Autowired
    private ProcessOfBuying process;

    @Autowired
    private BattleProcess battleProcess;

    @Autowired
    private HouseService houseService;

    @GetMapping("/armies")
    public ResponseEntity<List<Army>>  getAllInHouse(@RequestParam("house") String house){
        if (house.isEmpty()) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(armyService.getAllInHouse(house), HttpStatus.OK);
    }

    @GetMapping("/typesquads")
    public ResponseEntity<List<TypeSquadResponse>> getTypes(){
        List<TypeSquadResponse> responses = new ArrayList<>();
        for (TypeSquad typeSquad : TypeSquad.values())
            responses.add(new TypeSquadResponse(typeSquad.getTypeName(), typeSquad.getCosts(), typeSquad.getForcePerPerson()));
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @PostMapping("/squad")
    public ResponseEntity<List<Army>> addSquad(@RequestBody SquadRequest request){
        if (request.getArmyId() == null || request.getNumber() == null || request.getType() == null || request.getNumber() <= 0)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        process.buySquad(request);
        return new ResponseEntity<>(armyService.getAllInHouse(request.getHouse()), HttpStatus.OK);
    }

    @PostMapping("/army")
    public ResponseEntity<List<Army>> addArmy(@RequestBody ArmyRequest request){
        String res = process.createArmy(request);
        if (res.equals("No ok")) return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(armyService.getAllInHouse(request.getNameHouse()), HttpStatus.OK);
    }

    @PostMapping("/battle")
    public ResponseEntity<BattleResponse> battle(@RequestBody BattleRequest request){
        if (!request.getCountryName().isEmpty() && request.getArmyId() != null && !request.getHouseName().isEmpty()) {
            String result = battleProcess.battle(request);
            BattleResponse response = new BattleResponse(result, armyService.getAllInHouse(request.getHouseName()));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
}
