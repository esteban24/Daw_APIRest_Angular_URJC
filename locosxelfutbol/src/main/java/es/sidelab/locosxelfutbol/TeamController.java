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
@RequestMapping("/team")
public class TeamController {

	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TeamRepository teamRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Team getTeam(@PathVariable long id) {
		return teamRepository.findOne(id);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modificar(@PathVariable long id, @RequestBody Team team, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.setName(id,team.getName());
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void deleteTeam(@PathVariable long id, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.delete(id);
		}
	}


}
