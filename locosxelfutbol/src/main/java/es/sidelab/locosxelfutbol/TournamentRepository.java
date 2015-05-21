package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
Tournament findById(long id);
	
	@Modifying
	@Transactional
	@Query("update Tournament x set x.name = ?2 where x.id=?1")
	void setName(long id, String name);
}