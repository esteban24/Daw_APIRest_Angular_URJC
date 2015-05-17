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
		
		Player player11 = new Player("Leo","Messi", Positions.Jugador, 26, null);
		Player player12 = new Player("Andresito de mi vida", "Iniesta", Positions.Jugador, 32, null);
		Player player13 = new Player("Luis", "Suarez", Positions.Jugador, 28, null);
		Player player14 = new Player("Claudio", "Bravo", Positions.Portero, 30, null);
		Player player15 = new Player("Ivan", "Rakitic", Positions.Jugador, 28, null);
		
		//Insert Team
		Team team3 = new Team("URJCJAI", "ArrayList jugadores3", 0, 0, 0, 0, 0, 0);
		
		Player player16 = new Player("Micael", "Gallego", Positions.Jugador, 22, null);
		Player player17 = new Player("Antonio", "Montemayor", Positions.Portero, 22, null);
		Player player18 = new Player("Julio", "Flores", Positions.Jugador, 22, null);
		Player player19 = new Player("Enrije", "Jabello", Positions.Jugador, 22, null);
		Player player20 = new Player("Alejandro", "del Amo", Positions.Jugador, 22, null);
		
		//Insert Team
		Team team4 = new Team("NewTeam","ArrayList jugadores4", 0, 0, 0, 0, 0, 0);
		
		Player player21 = new Player("Cristiano", "Ronaldo", Positions.Jugador, 30, null);
		Player player22 = new Player("Gareth", "Bale", Positions.Jugador, 24, null);
		Player player23 = new Player("Iker", "Casillas", Positions.Portero, 33, null);
		Player player24 = new Player("Karim", "Benzema", Positions.Jugador, 27, null);
		Player player25 = new Player("Tony", "Kroos", Positions.Jugador, 25, null);
		
		//Insert Team
		Team team5 = new Team("Minabo de Kiev","ArrayList jugadores5", 0, 0, 0, 0, 0, 0);
		
		Player player26 = new Player("Skrodan", "Mustafi", Positions.Jugador, 23, null);
		Player player27 = new Player("Nicolas", "Otamendi", Positions.Jugador, 30, null);
		Player player28 = new Player("Diego", "Alves", Positions.Portero, 30, null);
		Player player29 = new Player("Daniel", "Parejo", Positions.Jugador, 26, null);
		Player player30 = new Player("Alvaro", "Negredo", Positions.Jugador, 28, null);
		
		//Insert Team
		Team team6 = new Team("Aston Birras","ArrayList jugadores6", 0, 0, 0, 0, 0, 0);
		
		Player player31 = new Player("Arda", "Turan", Positions.Jugador, 28, null);
		Player player32 = new Player("Antoine", "Griezzmann", Positions.Jugador, 24, null);
		Player player33 = new Player("Jan","Oblack", Positions.Portero, 25, null);
		Player player34 = new Player("Diego", "Godin", Positions.Jugador, 29, null);
		Player player35 = new Player("Jorge", "Resurreccion", Positions.Jugador, 26, null);
		
		//Insert Team
		Team team7 = new Team("Pajax de Amsterdam","ArrayList jugadores7", 0, 0, 0, 0, 0, 0);
				
		//Insert Courts
		
		//Insert Referees
		Referee referee1 = new Referee("Luigi", "Colina");
		Referee referee2 = new Referee("Julio", "Borbalan");
		Referee referee3 = new Referee("Teixeira", "Vitienes");
		
		//Insert Matches
		Match mactch1 = new Match (team1, team2, 4, 3);
		Match mactch2 = new Match (team3, team4, 1, 2);
		Match mactch3 = new Match (team5, team6, 0, 7);
		Match mactch4 = new Match (team1, team3, 2, 2);
		Match mactch5 = new Match (team2, team6, 2, 6);
		Match mactch6 = new Match (team4, team5, 1, 0);
		Match mactch7 = new Match (team1, team6, 0, 0);
		Match mactch8 = new Match (team2, team5, 3, 2);
		Match mactch9 = new Match (team3, team4, 10, 3);
		
		
		
		
	}

}
