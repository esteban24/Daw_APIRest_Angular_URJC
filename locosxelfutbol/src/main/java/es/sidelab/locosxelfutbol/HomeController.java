package es.sidelab.locosxelfutbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	CourtRepository courtRepository;
	
	@Autowired
	GameRepository matchRepository;
	
	@Autowired
	RefereeRepository refereeRepository;

	//TODO emartin: meter autowireds

	//TODO emartin: crear los métodos de API REST para devolver objetos Response a las peticiones Request del cliente
}