package es.sidelab.locosxelfutbol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	CourtRepository courtRepository;
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	RefereeRepository refereeRepository;
	
	@Autowired
	TournamentRepository tournamentRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

}
