package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.House;

import java.util.List;

@Repository
public interface HeroRepository  extends JpaRepository<Hero, String> {

    List<Hero> getAllByHouseEquals(House house);
    Hero getByName(String name);
    List<Hero> getAllByIsReserveIsTrueAndHouse_NameEquals(String house);
}
