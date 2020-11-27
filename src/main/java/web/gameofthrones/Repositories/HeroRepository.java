package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Hero;

@Repository
public interface HeroRepository  extends JpaRepository<Hero, String> {
}
