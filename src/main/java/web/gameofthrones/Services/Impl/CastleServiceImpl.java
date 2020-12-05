package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Castle;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Repositories.CastleRepository;
import web.gameofthrones.Services.CastleService;
import web.gameofthrones.Services.CountryService;
import web.gameofthrones.Services.HouseService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CastleServiceImpl implements CastleService {

    @Autowired
    private CastleRepository castleRepository;

    @Autowired
    private HouseService houseService;

    @Autowired
    private CountryService countryService;

    @Override
    public List<Castle> getAllInHouse(String house) {
        List<Castle> castles = new ArrayList<>();
        List<Country> countries = countryService.getAllInHouse(house);
        for (Country country : countries) {
                Castle castle = castleRepository.findAllByCountryIs(country);
                if (castle != null) castles.add(castle);
        }
        return castles;
    }
}
