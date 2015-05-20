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
@RequestMapping("/courtAdmin")
public class CourtController {

	@Autowired
	private CourtRepository courtRepository;
	
	@RequestMapping(value = "/court" ,method = RequestMethod.GET)
	public List<Court> getTeams() {
		return courtRepository.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Court> getCourts() {
		return courtRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Court getCourt(@PathVariable long id) {
		return courtRepository.findOne(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Court> addCourt(@RequestBody Court court, HttpSession sesion){
		//if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			courtRepository.save(court);
			return new ResponseEntity<>(court, HttpStatus.CREATED);
		//}else{
			//return null;
		//}	
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modificar(@PathVariable long id, @RequestBody Court court, HttpSession sesion){
		//if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			courtRepository.setName(id,court.getName());
			courtRepository.setDescription(id,court.getDescription());
		//}
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public void deleteReferee(@PathVariable long id, HttpSession sesion){
		courtRepository.delete(id);
	}

}

