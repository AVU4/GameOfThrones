package web.gameofthrones.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.gameofthrones.Entities.AllianceMember;

@Repository
public interface AllianceMemberRepository  extends JpaRepository<AllianceMember, Long> {
}
