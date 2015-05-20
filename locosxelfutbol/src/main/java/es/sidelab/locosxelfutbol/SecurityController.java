package es.sidelab.locosxelfutbol;

import javax.persistence.Access;
import javax.servlet.http.HttpSession;

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
	}

	@RequestMapping(value= "/seguridad", method = RequestMethod.POST)
	public boolean pruebax(@RequestBody Access datos, HttpSession sesion) {
		if ((datos.mail.equals("admin@locosxelfutbol.com")) && (datos.pass.equals("1234"))) {
			sesion.setAttribute("admin", true);
			System.out.println("ENtro por seguridad");
			return true;
		} else {
			System.out.println("ENtro por seguridad");

			sesion.setAttribute("admin", false);
			return false;
		}

	}

}
