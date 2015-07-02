package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface TeamRepository extends JpaRepository<Team, Long> {
	Team findById(long id);
	
	@Query("FROM Team t where t.name = :name")
	Team findByName(@Param("name")String name);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.name = ?2 where t.id=?1")
	void setName(long id, String name);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.correo = ?2 where t.id=?1")
	void setCorreo(long id, String correo);
	
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
	
	@Modifying
	@Transactional
	@Query("update Team t set t.gf = ?2 where t.id=?1")
	void setGF(long id, int gf);
	
	@Modifying
	@Transactional
	@Query("update Team t set t.gc = ?2 where t.id=?1")
	void setGC(long id, int gc);
	
}