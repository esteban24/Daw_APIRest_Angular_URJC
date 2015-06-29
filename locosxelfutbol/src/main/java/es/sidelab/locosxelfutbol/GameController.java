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
				int draw = (int)local.getDraw();
				int draw2 = (int)visitant.getDraw();
				local.setDraw(draw+1);
				visitant.setDraw(draw2+1);
				System.out.println(visitant.getPoints());
				local.refreshPoints((int)local.getWin(), (int)local.getDraw(), (int)local.getDefeat());
				visitant.refreshPoints((int)visitant.getWin(), (int)visitant.getDraw(), (int)visitant.getDefeat());
				System.out.println(visitant.getPoints());
				teamRepository.setDrawGame(local.getId(), local.getDraw());
				teamRepository.setDrawGame(visitant.getId(), visitant.getDraw());
				teamRepository.setPoints(local.getId(), local.getPoints());
				teamRepository.setPoints(visitant.getId(), visitant.getPoints());
			}else if (goalslocal>goalsvisitant){
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
				int win = (int)visitant.getWin();
				int defeat = (int)local.getDefeat();
				visitant.setWin(win+1);
				local.setDefeat(defeat+1);
				System.out.println(visitant.getPoints());
				visitant.refreshPoints((int)visitant.getWin(), (int)visitant.getDraw(), (int)visitant.getDefeat());
				System.out.println(visitant.getPoints());
				teamRepository.setWinGame(visitant.getId(), visitant.getWin());
				teamRepository.setLostGame(local.getId(), local.getDefeat());
				teamRepository.setPoints(local.getId(), local.getPoints());
				teamRepository.setPoints(visitant.getId(), visitant.getPoints());
			}
			teamRepository.setGF(local.getId(), local.getGf()+gl);
			teamRepository.setGF(visitant.getId(), visitant.getGf()+gv);
			teamRepository.setGC(local.getId(), local.getGc()+gv);
			teamRepository.setGC(visitant.getId(), visitant.getGc()+gl);
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
