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
	TeamRepository teamRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Team> getTeams() {
		return teamRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Team getTeam(@PathVariable long id) {
		return teamRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Team> addTeam(@RequestBody Team team, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.save(team);
			return new ResponseEntity<>(team, HttpStatus.CREATED);
		}else{
			return null;
		}	
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modificar(@PathVariable long id, @RequestBody Team team, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.setName(id,team.getName());
			teamRepository.setPoints(id,team.getPoints());
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void deleteTeam(@PathVariable long id, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.delete(id);
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modifyWins(@PathVariable long id, int wins, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.setWinGame(id, wins);
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modifyDraws(@PathVariable long id, int draws, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.setDrawGame(id, draws);
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modifyLosts(@PathVariable long id, int losts, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.setLostGame(id, losts);
		}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modifyPoints(@PathVariable long id, int points, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			teamRepository.setPoints(id, points);
		}
	}


}
