package web.gameofthrones.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Request.BattleRequest;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.CountryService;
import web.gameofthrones.Services.HouseService;

@Service
public class BattleProcess {

    @Autowired
    private ArmyService armyService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private HouseService houseService;

    @Transactional
    public String battle(BattleRequest request){
        long idAttacker = request.getArmyId();
        Army army =  armyService.getOneByCountry(request.getCountryName());
        if (army == null){
            Country country = countryService.getByName(request.getCountryName());
            countryService.setHouse(houseService.getOneByName(request.getHouseName()), country.getName());
            countryService.refresh(country);
            armyService.setCountry(country, armyService.getOneById(idAttacker).getGeneral());
            armyService.refresh(armyService.getOneById(idAttacker));
            return "Поход завершён";
        }
        long idDefender = army.getId();
        String result = armyService.startBattle(idAttacker, idDefender);
        return result;
    }
}
