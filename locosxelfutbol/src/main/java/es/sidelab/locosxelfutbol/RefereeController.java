package es.sidelab.locosxelfutbol;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/referee")
public class RefereeController {

	@Autowired
	private RefereeRepository refereeRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Referee> getReferees() {
		return refereeRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public void modificar(@PathVariable long id, @RequestBody Referee referee, HttpSession sesion){
		//if((sesion!=null)&&((sesion.getAttribute("admin") != null)&&((Boolean)sesion.getAttribute("admin")))){
			refereeRepository.setName(id,referee.getName());
			refereeRepository.setLastName(id,referee.getLastName());
		//}
	}

}
