package web.gameofthrones.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Repositories.CountryRepository;
import web.gameofthrones.Services.CountryService;
import web.gameofthrones.Services.HouseService;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private HouseService houseService;

    @Override
    public List<Country> getAll() {
        return countryRepository.findAll();
    }

    @Override
    public List<Country> getAllInHouse(String house) {
        return countryRepository.findAllByHouseOwner_Name(house);
    }

}
