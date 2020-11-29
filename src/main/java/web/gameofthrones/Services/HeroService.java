package web.gameofthrones.Services;

import web.gameofthrones.Entities.Hero;

import java.util.List;

public interface HeroService {

    List<Hero> getAllInHouse(String name);

    List<Hero> getAll();
}
