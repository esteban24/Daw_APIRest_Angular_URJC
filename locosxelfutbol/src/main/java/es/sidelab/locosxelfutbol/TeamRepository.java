package es.sidelab.locosxelfutbol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Match, Long> {

}