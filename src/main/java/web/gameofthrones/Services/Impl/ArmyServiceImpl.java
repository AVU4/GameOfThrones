package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.Squad;
import web.gameofthrones.Repositories.ArmyRepository;
import web.gameofthrones.Repositories.SquadRepository;
import web.gameofthrones.Services.ArmyService;
import web.gameofthrones.Services.CountryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmyServiceImpl implements ArmyService {

    @Autowired
    private ArmyRepository armyRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private SquadRepository squadRepository;

    @Override
    public List<Army> getAll() {
        return armyRepository.findAll();
    }

    @Override
    public List<Army> getAllInHouse(String house) {
        List<Army> armies = new ArrayList<>();
        List<Country> countries = countryService.getAllInHouse(house);
        for (Country country : countries){
            Army army = armyRepository.getArmyByCountry_Name(country.getName());
            if (army != null) armies.add(army);
        }
        return armies;
    }

    @Override
    public Army getOneById(long id) {
        return armyRepository.getArmyById(id);
    }

    @Override
    public Squad addSquad(Squad squad) {
       return squadRepository.saveAndFlush(squad);
    }

    @Override
    public Squad getSquad(long id) {
        return squadRepository.getOne(id);
    }

    @Override
    public void refresh(Army army) {
        armyRepository.refresh(army);
    }

    @Override
    public void refreshSquad(Squad squad) {
        squadRepository.refresh(squad);
    }

    @Override
    public Army addArmy(Army army) {
        return armyRepository.saveAndFlush(army);
    }

    @Override
    public Army getOneByGeneralName(String name) {
        return armyRepository.getArmyByGeneral_Name(name);
    }

    @Override
    public void setCountry(Country country, Hero name) {
        armyRepository.setCountry(country, name);
    }


}
