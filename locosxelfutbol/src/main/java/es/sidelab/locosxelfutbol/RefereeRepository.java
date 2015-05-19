package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface RefereeRepository extends JpaRepository<Referee, Long> {
	Referee findById(long id);
	
	@Modifying
	@Transactional
	@Query("update Referee r set r.name = ?2 where r.id=?1")
	void setName(long id, String name);
	

	@Modifying
	@Transactional
	@Query("update Referee r set r.lastName = ?2 where r.id=?1")
	void setLastName(long id, String lastName);
	
}
