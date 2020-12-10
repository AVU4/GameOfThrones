package web.gameofthrones.Services;

import web.gameofthrones.Entities.Hero;

import java.util.List;

public interface HeroService {

    List<Hero> getAllInHouse(String name);
    Hero getByName(String name);
    List<Hero> getAllFromReserveInHouse(String house);
    List<Hero> getAll();
    void setReserve(boolean value, String name);
    void refresh(Hero hero);
}
