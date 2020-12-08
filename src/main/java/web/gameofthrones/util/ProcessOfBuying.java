package web.gameofthrones.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.gameofthrones.Entities.*;
import web.gameofthrones.Request.ArmyRequest;
import web.gameofthrones.Request.SquadRequest;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.CountryService;
import web.gameofthrones.Services.HeroService;
import web.gameofthrones.Services.HouseService;

@Service
public class ProcessOfBuying {

    @Autowired
    private HouseService houseService;

    @Autowired
    private ArmyService armyService;

    @Autowired
    private HeroService heroService;

    @Autowired
    private CountryService countryService;

    @Transactional
    public boolean buySquad(SquadRequest request){
        House order = houseService.getOneByName(request.getHouse());
        long golds = order.getCountGold();
        long neededGolds = request.getNumber() * TypeSquad.getCosts(request.getType());
        if (golds < neededGolds) return false;
        houseService.setGold(order.getName(), golds - neededGolds);
        houseService.refresh(order);
        Army army = armyService.getOneById(request.getArmyId());
        Squad squad = new Squad(army, order, request.getType(), request.getNumber(), TypeSquad.getForcePerPerson(request.getType()));
        armyService.addSquad(squad);
        armyService.refreshSquad(squad);
        armyService.refresh(army);
        return true;
    }

    public String createArmy(ArmyRequest armyRequest){
        if (armyRequest == null || armyRequest.getName() == null || armyRequest.getNameCountry() == null) return "No ok";
        Hero hero = heroService.getByName(armyRequest.getName());
        Country country = countryService.getByName(armyRequest.getNameCountry());
        Army army = new Army(hero, country);
        country.setHouseOwner(houseService.getOneByHeroName(hero.getName()));
        armyService.addArmy(army);
        armyService.refresh(army);
        return "Ok";
    }
}
