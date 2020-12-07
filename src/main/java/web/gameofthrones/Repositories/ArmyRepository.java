package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Squad;

import java.util.List;

public interface ArmyRepository extends JpaRepository<Army, Long> {

    Army getArmyByCountry_Name(String name);
    Army getArmyById(long id);
}
