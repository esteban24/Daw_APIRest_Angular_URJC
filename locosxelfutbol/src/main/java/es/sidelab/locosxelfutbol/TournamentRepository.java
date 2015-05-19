package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {

	@Modifying
	@Transactional
	@Query("update Tournament f set f.name = ?2 where f.id=?1")
	void setName(long id, String name);
	
}
