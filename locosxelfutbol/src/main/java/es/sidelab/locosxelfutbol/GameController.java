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
	@Autowired
	TeamRepository teamRepository;
	
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
			String loc = game.getLocal();
			String vis = game.getVisitant();
			int gl = game.getGoalsLocal();
			int gv = game.getGoalsVisitant();
			Team local = teamRepository.findByName(game.getLocal());
			Team visitant = teamRepository.findByName(game.getVisitant());
			System.out.println(visitant.getPoints());
			int goalslocal = game.getGoalsLocal();
			int goalsvisitant = game.getGoalsVisitant();
			if (goalslocal==goalsvisitant){
				local.setDraw(local.getDraw()+1);
				visitant.setDraw(visitant.getDraw()+1);
				local.refreshPoints(local.getWin(), local.getDraw(), local.getDefeat());
				local.refreshPoints(visitant.getWin(), visitant.getDraw(), visitant.getDefeat());
				teamRepository.setDrawGame(local.getId(), local.getDraw());
				teamRepository.setDrawGame(visitant.getId(), visitant.getDraw());
			}else if (goalslocal>goalsvisitant){
				//System.out.println("equipo"+local.getName());
				//System.out.println("equipo"+local.getWin());
				int win = (int)local.getWin();
				int defeat = (int)visitant.getDefeat();
				local.setWin(win+1);
				visitant.setDefeat(defeat+1);
				System.out.println(visitant.getPoints());
				local.refreshPoints((int)local.getWin(), (int)local.getDraw(), (int)local.getDefeat());
				System.out.println(visitant.getPoints());
				teamRepository.setWinGame(local.getId(), local.getWin());
				teamRepository.setLostGame(visitant.getId(), visitant.getDefeat());
				teamRepository.setPoints(local.getId(), local.getPoints());
				teamRepository.setPoints(visitant.getId(), visitant.getPoints());
			}else if (goalslocal<goalsvisitant){
				visitant.setWin(local.getWin()+1);
				local.setDefeat(visitant.getDefeat()+1);
				local.refreshPoints(local.getWin(), local.getDraw(), local.getDefeat());
				local.refreshPoints(visitant.getWin(), visitant.getDraw(), visitant.getDefeat());
				teamRepository.setWinGame(visitant.getId(), visitant.getWin());
				teamRepository.setLostGame(local.getId(), local.getDefeat());
			}
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
