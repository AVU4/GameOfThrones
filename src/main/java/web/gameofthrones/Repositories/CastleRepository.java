package web.gameofthrones.Repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Castle;
import web.gameofthrones.Entities.Country;

import java.util.List;

@Repository
public interface CastleRepository extends JpaRepository<Castle, String> {

    Castle findAllByCountryIs(Country country);
}
