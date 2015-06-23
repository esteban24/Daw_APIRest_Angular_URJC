package es.sidelab.locosxelfutbol;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface TeamRepository extends JpaRepository<Team, Long> {
	Team findById(long id);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.name = ?2 where t.id=?1")
	void setName(long id, String name);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.points = ?2 where t.id=?1")
	void setPoints(long id, int points);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.points = ?2 where t.id=?1")
	void setWinGame(long id, int wins);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.points = ?2 where t.id=?1")
	void setDrawGame(long id, int draws);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.points = ?2 where t.id=?1")
	void setLostGame(long id, int losts);
	
}