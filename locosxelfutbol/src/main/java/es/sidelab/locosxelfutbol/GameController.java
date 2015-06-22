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
@RequestMapping("/gameAdmin")
public class GameController {
	
	@Autowired
	GameRepository gameRepository;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Game getGame(@PathVariable long id) {
		return gameRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Game> getGames() {
		return gameRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Game> addGame(@RequestBody Game game, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			gameRepository.save(game);
			return new ResponseEntity<>(game, HttpStatus.CREATED);
		}else{
			return null;
		}	
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void deleteGame(@PathVariable long id, HttpSession sesion){
		if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			gameRepository.delete(id);
		}
	}

}
