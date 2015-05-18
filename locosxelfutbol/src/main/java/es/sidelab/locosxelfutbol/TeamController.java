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
	private TeamRepository teamRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}

}
