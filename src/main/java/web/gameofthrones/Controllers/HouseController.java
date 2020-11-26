package web.gameofthrones.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@RestController
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/houses")
    public List<House> getAll(){
        return houseService.getAll();
    }
}
