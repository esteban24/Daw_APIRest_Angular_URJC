package es.sidelab.locosxelfutbol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournamentAdmin")
public class TournamentController {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	
	
	@RequestMapping(value="/torneos", method = RequestMethod.GET)
	public List<Tournament> getTournament() {
		return tournamentRepository.findAll();
	}
}
	