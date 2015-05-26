package es.sidelab.locosxelfutbol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/match")
public class MatchController {
	
	@Autowired
	MatchRepository matchRepository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Match> getPlayers() {
		return matchRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Match> addMatch(@RequestBody Match match, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			matchRepository.save(match);
			return new ResponseEntity<>(match, HttpStatus.CREATED);
		}else{
			return null;
		}	
	}
	

}
