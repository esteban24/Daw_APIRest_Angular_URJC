package es.sidelab.locosxelfutbol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/refereeAdmin")
public class TournamentController {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tournament> getTournament() {
		return tournamentRepository.findAll();
	}
}
	