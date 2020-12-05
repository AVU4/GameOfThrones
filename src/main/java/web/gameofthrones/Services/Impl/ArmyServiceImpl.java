package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Repositories.ArmyRepository;
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
}
