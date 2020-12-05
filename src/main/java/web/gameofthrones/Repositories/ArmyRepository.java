package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.gameofthrones.Entities.Army;

import java.util.List;

public interface ArmyRepository extends JpaRepository<Army, Long> {

    Army getArmyByCountry_Name(String name);
}
