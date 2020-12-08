package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.House;

import java.util.List;

@Repository
public interface HeroRepository  extends JpaRepository<Hero, String> {

    List<Hero> getAllByHouseEquals(House house);
    Hero getByName(String name);

    @Query("select hero from Hero hero where hero.isReserve = true and hero.house.name = :house ")
    List<Hero> getReserves(@Param("house") String house);
}
