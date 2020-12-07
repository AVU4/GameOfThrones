package web.gameofthrones.Controllers;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Request.SquadRequest;
import web.gameofthrones.Responces.TypeSquadResponse;
import web.gameofthrones.Services.ArmyService;
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

    @GetMapping("/armies")
    public List<Army>  getAllInHouse(@RequestParam("house") String house){
        return armyService.getAllInHouse(house);
    }

    @GetMapping("/typesquads")
    public List<TypeSquadResponse> getTypes(){
        List<TypeSquadResponse> responses = new ArrayList<>();
        for (TypeSquad typeSquad : TypeSquad.values())
            responses.add(new TypeSquadResponse(typeSquad.getTypeName(), typeSquad.getCosts(), typeSquad.getForcePerPerson()));
        return responses;
    }

    @PostMapping("/squad")
    public String addSquad(@RequestBody SquadRequest request){
        if (request.getArmyId() == null || request.getNumber() == null || request.getType() == null)
            return "No ok";
        process.buySquad(request);
        return "Ок";
    }
}
