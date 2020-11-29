package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.Country;

@Repository
public interface CountryRepository  extends JpaRepository<Country, String> {
}
