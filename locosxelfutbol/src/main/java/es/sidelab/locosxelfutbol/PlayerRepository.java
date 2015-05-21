package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PlayerRepository extends JpaRepository<Player, Long> {
	Player findById(long id);
	
	@Modifying
	@Transactional
	@Query("update Player p set p.name = ?2 where p.id=?1")
	void setName(long id, String name);
	
}

