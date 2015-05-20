package es.sidelab.locosxelfutbol;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourtRepository extends JpaRepository<Court, Long> {
Court findById(long id);
	
	@Modifying
	@Transactional
	@Query("update Court c set c.name = ?2 where c.id=?1")
	void setName(long id, String name);

	@Modifying
	@Transactional
	@Query("update Court c set c.description = ?2 where c.id=?1")
	void setDescription(long id, String description);
}
