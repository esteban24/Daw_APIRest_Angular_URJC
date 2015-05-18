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
		playerRepository.save(player1);
		Player player2  = new Player("David", "Robles", Positions.Portero, 19 , null );
		playerRepository.save(player2);
		Player player3  = new Player("Juan", "Pérez", Positions.Portero, 20 , null );
		playerRepository.save(player3);
		Player player4  = new Player("Carlos", "Fuentes", Positions.Jugador, 18 , null );
		playerRepository.save(player4);
		Player player5  = new Player("Juan Carlos", "Martín", Positions.Jugador, 18 , null );
		playerRepository.save(player5);
		
		//TODO emartin: Cambiar la clase Team cuando se resuelva lo de la BBDD
		//Insert Team
		Team team1 = new Team("Los Franciscanos", "ArrayList jugadores1", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team1);
		
		Player player6  = new Player("Francisco", "Pizarro", Positions.Jugador, 21 , null );
		playerRepository.save(player6);
		Player player7  = new Player("Francisco", "Ibáñez", Positions.Jugador, 18 , null );
		playerRepository.save(player7);
		Player player8  = new Player("Francisco", "de Lucía", Positions.Portero, 18 , null );
		playerRepository.save(player8);
		Player player9  = new Player("Francisco", "Carmona", Positions.Jugador, 18 , null );
		playerRepository.save(player9);
		Player player10 = new Player("Francisco", "Alarcón", Positions.Jugador, 18 , null );
		playerRepository.save(player10);
		
		//Insert Team
		Team team2 = new Team("Steaua Del Water", "ArrayList jugadores2", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team2);

		
		Player player11 = new Player("Leo","Messi", Positions.Jugador, 26, null);
		playerRepository.save(player11);
		Player player12 = new Player("Andresito de mi vida", "Iniesta", Positions.Jugador, 32, null);
		playerRepository.save(player12);
		Player player13 = new Player("Luis", "Suarez", Positions.Jugador, 28, null);
		playerRepository.save(player13);
		Player player14 = new Player("Claudio", "Bravo", Positions.Portero, 30, null);
		playerRepository.save(player14);
		Player player15 = new Player("Ivan", "Rakitic", Positions.Jugador, 28, null);
		playerRepository.save(player15);
		
		//Insert Team
		Team team3 = new Team("URJCJAI", "ArrayList jugadores3", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team3);

		
		Player player16 = new Player("Micael", "Gallego", Positions.Jugador, 22, null);
		playerRepository.save(player16);
		Player player17 = new Player("Antonio", "Montemayor", Positions.Portero, 22, null);
		playerRepository.save(player17);
		Player player18 = new Player("Julio", "Flores", Positions.Jugador, 22, null);
		playerRepository.save(player18);
		Player player19 = new Player("Enrije", "Jabello", Positions.Jugador, 22, null);
		playerRepository.save(player19);
		Player player20 = new Player("Alejandro", "del Amo", Positions.Jugador, 22, null);
		playerRepository.save(player20);
		
		//Insert Team
		Team team4 = new Team("NewTeam","ArrayList jugadores4", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team4);

		
		Player player21 = new Player("Cristiano", "Ronaldo", Positions.Jugador, 30, null);
		playerRepository.save(player21);
		Player player22 = new Player("Gareth", "Bale", Positions.Jugador, 24, null);
		playerRepository.save(player22);
		Player player23 = new Player("Iker", "Casillas", Positions.Portero, 33, null);
		playerRepository.save(player23);
		Player player24 = new Player("Karim", "Benzema", Positions.Jugador, 27, null);
		playerRepository.save(player24);
		Player player25 = new Player("Tony", "Kroos", Positions.Jugador, 25, null);
		playerRepository.save(player25);
		
		//Insert Team
		Team team5 = new Team("Minabo de Kiev","ArrayList jugadores5", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team5);

		
		Player player26 = new Player("Skrodan", "Mustafi", Positions.Jugador, 23, null);
		playerRepository.save(player26);
		Player player27 = new Player("Nicolas", "Otamendi", Positions.Jugador, 30, null);
		playerRepository.save(player27);
		Player player28 = new Player("Diego", "Alves", Positions.Portero, 30, null);
		playerRepository.save(player28);
		Player player29 = new Player("Daniel", "Parejo", Positions.Jugador, 26, null);
		playerRepository.save(player29);
		Player player30 = new Player("Alvaro", "Negredo", Positions.Jugador, 28, null);
		playerRepository.save(player30);
		
		//Insert Team
		Team team6 = new Team("Aston Birras","ArrayList jugadores6", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team6);

		
		Player player31 = new Player("Arda", "Turan", Positions.Jugador, 28, null);
		playerRepository.save(player31);
		Player player32 = new Player("Antoine", "Griezzmann", Positions.Jugador, 24, null);
		playerRepository.save(player32);
		Player player33 = new Player("Jan","Oblack", Positions.Portero, 25, null);
		playerRepository.save(player33);
		Player player34 = new Player("Diego", "Godin", Positions.Jugador, 29, null);
		playerRepository.save(player34);
		Player player35 = new Player("Jorge", "Resurreccion", Positions.Jugador, 26, null);
		playerRepository.save(player35);
		
		//Insert Team
		Team team7 = new Team("Pajax de Amsterdam","ArrayList jugadores7", 0, 0, 0, 0, 0, 0);
		teamRepository.save(team7);

				
		//Insert Courts
		
		//Insert Referees
		Referee referee1 = new Referee("Luigi", "Colina");
		refereeRepository.save(referee1);
		Referee referee2 = new Referee("Julio", "Borbalan");
		refereeRepository.save(referee2);
		Referee referee3 = new Referee("Teixeira", "Vitienes");
		refereeRepository.save(referee3);
		
		//Insert Matches
		//TODO emartin: cambiados los equipos de Team a String para que el proyecto compile a falta de 
		//añadir la parte de BBDD y las relaciones entre tablas
		Match match1 = new Match ("team1", "team2", 4, 3);
		matchRepository.save(match1);
		Match match2 = new Match ("team3", "team4", 1, 2);
		matchRepository.save(match2);
		Match match3 = new Match ("team5", "team6", 0, 7);
		matchRepository.save(match3);
		Match match4 = new Match ("team1", "team3", 2, 2);
		matchRepository.save(match4);
		Match match5 = new Match ("team2", "team6", 2, 6);
		matchRepository.save(match5);
		Match match6 = new Match ("team4", "team5", 1, 0);
		matchRepository.save(match6);
		Match match7 = new Match ("team1", "team6", 0, 0);
		matchRepository.save(match7);
		Match match8 = new Match ("team2", "team5", 3, 2);
		matchRepository.save(match8);
		Match match9 = new Match ("team3", "team4", 10, 3);
		matchRepository.save(match9);
		
		
		
		
	}

}
