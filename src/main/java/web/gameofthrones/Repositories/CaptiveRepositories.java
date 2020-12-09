package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Captive;
import web.gameofthrones.Entities.House;

import java.util.List;

@Repository
public interface CaptiveRepositories extends JpaRepository<Captive, Long> {

    List<Captive> findAllByHouseOwner_Name(String house);
    List<Captive> findAllByHero_House_NameAndHouseOwnerIsNot(String name, House house);
    long deleteCaptiveByHero_Name(String name);
}
