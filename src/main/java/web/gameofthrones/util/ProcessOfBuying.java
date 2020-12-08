package web.gameofthrones.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Entities.Squad;
import web.gameofthrones.Request.SquadRequest;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.HouseService;

@Service
public class ProcessOfBuying {

    @Autowired
    private HouseService houseService;

    @Autowired
    private ArmyService armyService;


    @Transactional
    public boolean buySquad(SquadRequest request){
        House order = houseService.getOneByName(request.getHouse());
        long golds = order.getCountGold();
        long neededGolds = request.getNumber() * TypeSquad.getCosts(request.getType());
        if (golds < neededGolds) return false;
        houseService.setGold(order.getName(), golds - neededGolds);
        houseService.refresh(order);
        System.out.println(order.getCountGold());
        Army army = armyService.getOneById(request.getArmyId());
        Squad squad = new Squad(army, order, request.getType(), request.getNumber(), TypeSquad.getForcePerPerson(request.getType()));
        armyService.addSquad(squad);
        armyService.refreshSquad(squad);
        armyService.refresh(army);
        return true;
    }
}
