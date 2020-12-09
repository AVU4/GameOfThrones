package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.House;
import web.gameofthrones.Repositories.Custom.CustomRepository;

import java.util.List;

@Repository
public interface CountryRepository  extends CustomRepository<Country, String> {

    List<Country> findAllByHouseOwner_Name(String name);
    List<Country> findAllByHouseOwnerIsNull();
    List<Country> findAllByArmyIsNull();
    List<Country> findAllByHouseOwner_NameIsNot(String name);
    Country getByName(String name);

    @Modifying
    @Query("update Country c set c.houseOwner = :house where c.name = :country ")
    void setCountry(@Param("house") House house, @Param("country") String country);
}
