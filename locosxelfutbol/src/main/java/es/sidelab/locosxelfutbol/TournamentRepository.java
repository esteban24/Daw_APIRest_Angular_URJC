package es.sidelab.locosxelfutbol;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Match, Long> {

}