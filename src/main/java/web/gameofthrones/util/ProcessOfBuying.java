package web.gameofthrones.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.gameofthrones.Entities.*;
import web.gameofthrones.Request.ArmyRequest;
import web.gameofthrones.Request.SquadRequest;
import web.gameofthrones.Services.*;

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

    @Autowired
    private CaptiveService captiveService;

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

    @Transactional
    public String createArmy(ArmyRequest armyRequest){
        if (armyRequest == null || armyRequest.getName() == null || armyRequest.getNameCountry() == null) return "No ok";
        Hero hero = heroService.getByName(armyRequest.getName());
        Country country = countryService.getByName(armyRequest.getNameCountry());
        Army army = armyService.getOneByGeneralName(hero.getName());
        countryService.setHouse(houseService.getOneByHeroName(hero.getName()), armyRequest.getNameCountry());
        countryService.refresh(country);
        if (army == null){
            army = new Army(hero, country);
            armyService.addArmy(army);
        }else {
            if (army.getForce() == null) army.setForce(0);
            armyService.setCountry(country, hero);
        }
        armyService.refresh(army);
        return "Ok";
    }

    @Transactional
    public String buyCaptive(String nameHero){
        if (!nameHero.isEmpty()){
            House house = houseService.getOneByHeroName(nameHero);
            if (house.getCountGold() < 30000) return "No ok";
            houseService.setGold(house.getName(), house.getCountGold() - 30000);
            houseService.refresh(house);
            Hero hero = heroService.getByName(nameHero);
            hero.setReserve(true);
            captiveService.deleteCaptive(hero.getName());
            return "OK";
        }else return "No ok";
    }
}
