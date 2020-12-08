package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Squad;
import web.gameofthrones.Repositories.Custom.CustomRepository;

import java.util.List;

public interface ArmyRepository extends CustomRepository<Army, Long> {

    Army getArmyByCountry_Name(String name);
    Army getArmyById(long id);
}
