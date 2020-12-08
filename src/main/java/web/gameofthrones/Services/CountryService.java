package web.gameofthrones.Services;

import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.House;

import java.util.List;

public interface CountryService {

    List<Country> getAll();
    List<Country> getAllInHouse(String house);
    List<Country> getAllFreeCountry();
    Country getByName(String name);
}
