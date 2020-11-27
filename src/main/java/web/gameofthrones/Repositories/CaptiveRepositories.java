package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Captive;

@Repository
public interface CaptiveRepositories extends JpaRepository<Captive, Long> {
}
