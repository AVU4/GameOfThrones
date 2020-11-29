package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import web.gameofthrones.Entities.Army;

public interface ArmyRepository extends JpaRepository<Army, Long> {
}
