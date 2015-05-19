package es.sidelab.locosxelfutbol;

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

	@RequestMapping(value= "/seguridad", method = RequestMethod.GET)
	public void pruebax(@RequestBody Access datos, HttpSession sesion) {
		System.out.println("ENtro por seguridad");

		if ((datos.mail.equals("admin@locosxelfutbol.com")) && (datos.pass.equals("1234"))) {
			sesion.setAttribute("admin", true);
		} else {
			sesion.setAttribute("admin", false);
		}

	}

}
