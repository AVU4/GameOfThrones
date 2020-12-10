package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Repositories.Custom.CustomRepository;

import java.util.List;

@Repository
public interface HeroRepository  extends CustomRepository<Hero, String> {

    List<Hero> getAllByHouseEquals(House house);
    Hero getByName(String name);

    @Modifying
    @Query(" update Hero h set h.isReserve = false where h.name = :hero ")
    void setReverseFalse(@Param("hero") String name);

    @Query("select hero from Hero hero where hero.isReserve = true and hero.house.name = :house ")
    List<Hero> getReserves(@Param("house") String house);
}
