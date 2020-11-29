package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.MemberBattle;

@Repository
public interface MemberBattleRepository extends JpaRepository<MemberBattle, Long> {
}
