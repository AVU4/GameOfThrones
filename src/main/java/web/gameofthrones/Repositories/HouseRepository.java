package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.House;

@Repository
public interface HouseRepository extends JpaRepository<House, String> {

    House getHouseByName(String name);
    House getHouseByHeroesEquals(Hero hero);

    @Modifying
    @Query("update House house set house.countGold = :golds where house.name = :house ")
    void setGold(@Param("house") String house, @Param("golds") long golds);
}
