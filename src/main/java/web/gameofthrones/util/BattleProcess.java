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

@Service
public class BattleProcess {

    @Autowired
    private ArmyService armyService;

    @Transactional
    public String battle(BattleRequest request){
        long idAttacker = request.getArmyId();
        Army army =  armyService.getOneByCountry(request.getCountryName());
        if (army == null) return "Поход завершён";
        long idDefender = army.getId();
        String result = armyService.startBattle(idAttacker, idDefender);
        return result;
    }
}
