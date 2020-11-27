package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Alliance;

@Repository
public interface AllianceRepository extends JpaRepository<Alliance, String> {
}
