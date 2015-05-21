package es.sidelab.locosxelfutbol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tournamentAdmin")
public class TournamentController {

	@Autowired
	private TournamentRepository tournamentRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Tournament> getTournaments() {
		return tournamentRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Tournament getTournament(@PathVariable long id) {
		return tournamentRepository.findOne(id);
	}
	
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modificar(@PathVariable long id, @RequestBody Tournament tournament, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			tournamentRepository.setName(id,tournament.getName());
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void deleteTournament(@PathVariable long id, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			tournamentRepository.delete(id);
		}
	}

}