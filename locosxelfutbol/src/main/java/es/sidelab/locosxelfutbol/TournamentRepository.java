package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
	Tournament findById(long id);
	
	@Modifying
	@Transactional
	@Query("update Tournament t set t.name = ?2 where t.id=?1")
	void setName(long id, String name);
}
