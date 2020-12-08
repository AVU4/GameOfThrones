package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.House;

import java.util.List;

@Repository
public interface CountryRepository  extends JpaRepository<Country, String> {

    List<Country> findAllByHouseOwner_Name(String name);
    List<Country> findAllByHouseOwnerIsNull();
    Country getByName(String name);
}
