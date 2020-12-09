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

    @Override
    public List<Country> getAllFreeCountry() {
        return countryRepository.findAllByHouseOwnerIsNull();
    }

    @Override
    public Country getByName(String name) {
        return countryRepository.getByName(name);
    }

    @Override
    public void refresh(Country country) {
        countryRepository.refresh(country);
    }

    @Override
    public void setHouse(House house, String nameCountry) {
        countryRepository.setCountry(house, nameCountry);
    }

    @Override
    public List<Country> getEnemyCountry(String name) {
        return countryRepository.findAllByHouseOwner_NameIsNot(name);
    }
}
