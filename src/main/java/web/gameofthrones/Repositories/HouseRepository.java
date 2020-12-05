package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.House;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {

    House getHouseByName(String name);
    House getHouseByHeroesEquals(Hero hero);
}
