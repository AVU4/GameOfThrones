package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import web.gameofthrones.Entities.Army;
import web.gameofthrones.Entities.Country;
import web.gameofthrones.Entities.Hero;
import web.gameofthrones.Entities.Squad;
import web.gameofthrones.Repositories.Custom.CustomRepository;

import java.util.List;

public interface ArmyRepository extends CustomRepository<Army, Long> {

    Army getArmyByCountry_Name(String name);
    Army getArmyById(long id);
    Army getArmyByGeneral_Name(String name);

    @Modifying
    @Query("update Army army set army.country = :country where army.general = :hero ")
    void setCountry(@Param("country") Country country, @Param("hero") Hero name);


    @Query(value = " select battle (:idAttacker , :idDefender ) ", nativeQuery = true)
    String battle(@Param("idAttacker") long firstId, @Param("idDefender") long secondId);
}
