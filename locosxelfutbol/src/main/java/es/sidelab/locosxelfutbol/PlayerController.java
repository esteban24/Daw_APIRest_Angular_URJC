package es.sidelab.locosxelfutbol;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	PlayerRepository playerRepository;
	
	@RequestMapping(value = "/jugadores" ,method = RequestMethod.GET)
	public List<Player> getPlayers() {
		return playerRepository.findAll();
	}

}