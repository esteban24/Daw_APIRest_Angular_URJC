package es.sidelab.locosxelfutbol;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/adminLogin")
public class SecurityController {

	public static class Access {
		public String mail;
		public String pass;
		
		public 	Access (){
			this.mail = "";
			this.pass = "";
		}
		
		public Access(String mail, String pass){
			this.mail=mail;
			this.pass=pass;
		}

		public String getMail() {
			return mail;
		}

		public void setMail(String mail) {
			this.mail = mail;
		}

		public String getPass() {
			return pass;
		}

		public void setPass(String pass) {
			this.pass = pass;
		}
	}
	
	@Autowired 
	private TeamRepository teamrepository;

	@RequestMapping(value= "/seguridadUsuario", method = RequestMethod.POST)
	public boolean loginTeam(@RequestBody Access datos, HttpSession sesion){
		boolean devolver=false;
		for(Team team: teamrepository.findAll()){
			if((team.getCorreo().equalsIgnoreCase(datos.mail))&& (team.getContrasenia().equalsIgnoreCase(datos.pass))){
				sesion.setAttribute("user", true);
				devolver=true;
			} else {
				sesion.setAttribute("user", false);
				devolver=false;
			}
		}
		return devolver;
	}
	
	@RequestMapping(value= "/seguridad", method = RequestMethod.POST)
	public boolean pruebax(@RequestBody Access datos, HttpSession sesion) {
		if ((datos.mail.equals("admin@locosxelfutbol.com")) && (datos.pass.equals("1234"))) {
			sesion.setAttribute("admin", true);
			return true;
		} else {

			sesion.setAttribute("admin", false);
			return false;
		}

	}

}
