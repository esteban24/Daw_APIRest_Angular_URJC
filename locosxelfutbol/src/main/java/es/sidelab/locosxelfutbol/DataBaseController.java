package es.sidelab.locosxelfutbol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.sidelab.locosxelfutbol.Player;

@Controller
public class DataBaseController implements CommandLineRunner{
	
	//TODO emartin: meter autowired
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	TeamRepository teamRepository;
	
	@Autowired
	CourtRepository courtRepository;
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	RefereeRepository refereeRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		//Insert Players
		Player player1  = new Player("Óscar", "Sanchez", Positions.Jugador, 18 , null );
		Player player2  = new Player("David", "Robles", Positions.Portero, 19 , null );
		Player player3  = new Player("Juan", "Pérez", Positions.Portero, 20 , null );
		Player player4  = new Player("Carlos", "Fuentes", Positions.Jugador, 18 , null );
		Player player5  = new Player("Juan Carlos", "Martín", Positions.Jugador, 18 , null );
		
		//TODO emartin: Cambiar la clase Team cuando se resuelva lo de la BBDD
		//Insert Team
		Team team1 = new Team("Los Franciscanos", "ArrayList jugadores1", 0, 0, 0, 0, 0, 0);
		
		Player player6  = new Player("Francisco", "Pizarro", Positions.Jugador, 21 , null );
		Player player7  = new Player("Francisco", "Ibáñez", Positions.Jugador, 18 , null );
		Player player8  = new Player("Francisco", "de Lucía", Positions.Portero, 18 , null );
		Player player9  = new Player("Francisco", "Carmona", Positions.Jugador, 18 , null );
		Player player10 = new Player("Francisco", "Alarcón", Positions.Jugador, 18 , null );
		
		//Insert Team
		Team team2 = new Team("Steaua Del Water", "ArrayList jugadores2", 0, 0, 0, 0, 0, 0);
		
		Player player11 = new Player();
		Player player12 = new Player();
		Player player13 = new Player();
		Player player14 = new Player();
		Player player15 = new Player();
		
		//Insert Team
		Team team3 = new Team("URJCJAI", "ArrayList jugadores3", 0, 0, 0, 0, 0, 0);
		
		Player player16 = new Player();
		Player player17 = new Player();
		Player player18 = new Player();
		Player player19 = new Player();
		Player player20 = new Player();
		
		//Insert Team
		Team team4 = new Team("NewTeam","ArrayList jugadores4", 0, 0, 0, 0, 0, 0);
		
		Player player21 = new Player();
		Player player22 = new Player();
		Player player23 = new Player();
		Player player24 = new Player();
		Player player25 = new Player();
		
		//Insert Team
		Team team5 = new Team("Minabo de Kiev","ArrayList jugadores5", 0, 0, 0, 0, 0, 0);
		
		Player player26 = new Player();
		Player player27 = new Player();
		Player player28 = new Player();
		Player player29 = new Player();
		Player player30 = new Player();
		
		//Insert Team
		Team team6 = new Team("Aston Birras","ArrayList jugadores6", 0, 0, 0, 0, 0, 0);
		
		Player player31 = new Player();
		Player player32 = new Player();
		Player player33 = new Player();
		Player player34 = new Player();
		Player player35 = new Player();
		
		//Insert Team
		Team team7 = new Team("Pajax de Amsterdam","ArrayList jugadores7", 0, 0, 0, 0, 0, 0);
				
		//Insert Courts
		
		//Insert Referees
		
		//Insert Matches
		
		
	}

}
