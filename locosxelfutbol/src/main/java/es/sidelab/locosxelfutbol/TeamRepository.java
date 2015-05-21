package es.sidelab.locosxelfutbol;

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

}