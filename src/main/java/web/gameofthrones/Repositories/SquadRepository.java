package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Squad;
import web.gameofthrones.Repositories.Custom.CustomRepository;
import web.gameofthrones.Repositories.Custom.CustomRepositoryImpl;

@Repository
public interface SquadRepository extends CustomRepository<Squad, Long> {

}
