package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Battle;

@Repository
public interface BattleRepository extends JpaRepository<Battle, Long> {
}
