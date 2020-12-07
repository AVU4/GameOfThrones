package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Squad;

@Repository
public interface SquadRepository extends JpaRepository<Squad, Long> {
}
