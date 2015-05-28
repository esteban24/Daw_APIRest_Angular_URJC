package es.sidelab.locosxelfutbol;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.sidelab.locosxelfutbol.Player;

@Controller
public class DataBaseController implements CommandLineRunner{
	
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
	
	@Autowired
	TournamentRepository tournamentRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		
		//Codigo de la BBDD
		//Insert Players
		Player player1  = new Player("Óscar", "Sanchez", Positions.Jugador, 18 , null );
		Player player2  = new Player("David", "Robles", Positions.Portero, 19 , null );
		Player player3  = new Player("Juan", "Pérez", Positions.Portero, 20 , null );
		Player player4  = new Player("Carlos", "Fuentes", Positions.Jugador, 18 , null );
		Player player5  = new Player("Juan Carlos", "Martín", Positions.Jugador, 18 , null );
		
		List<Player> players1 = new ArrayList<Player>();
		players1.add(player1);
		players1.add(player2);
		players1.add(player3);
		players1.add(player4);
		players1.add(player5);

		//Insert Team
		Team team1 = new Team("Steaua Del Water", players1, 0, 0, 0, 0, 0, 0,"equipo1@team.com","1234");
		//teamRepository.save(team1);
		
		//Set Teams
		player1.setTeam(team1);
		player2.setTeam(team1);
		player3.setTeam(team1);
		player4.setTeam(team1);
		player5.setTeam(team1);
		
		Player player6  = new Player("Francisco", "Pizarro", Positions.Jugador, 21 , null );
		Player player7  = new Player("Francisco", "Ibáñez", Positions.Jugador, 18 , null );
		Player player8  = new Player("Francisco", "de Lucía", Positions.Portero, 18 , null );
		Player player9  = new Player("Francisco", "Carmona", Positions.Jugador, 18 , null );
		Player player10 = new Player("Francisco", "Alarcón", Positions.Jugador, 18 , null );
		
		List<Player> players2 = new ArrayList<Player>();
		players2.add(player6);
		players2.add(player7);
		players2.add(player8);
		players2.add(player9);
		players2.add(player10);

		//Insert Team
		Team team2 = new Team("Los Franciscanos", players2, 0, 0, 0, 0, 0, 0,"equipo2@team.com","1234");
		//teamRepository.save(team2);
		
		//Set Teams
		
		player6.setTeam(team2);
		player7.setTeam(team2);
		player8.setTeam(team2);
		player9.setTeam(team2);
		player10.setTeam(team2);

		
		Player player11 = new Player("Leo","Messi", Positions.Jugador, 26, null);
		Player player12 = new Player("Andresito de mi vida", "Iniesta", Positions.Jugador, 32, null);
		Player player13 = new Player("Luis", "Suarez", Positions.Jugador, 28, null);
		Player player14 = new Player("Claudio", "Bravo", Positions.Portero, 30, null);
		Player player15 = new Player("Ivan", "Rakitic", Positions.Jugador, 28, null);
		
		List<Player> players3 = new ArrayList<Player>();
		players3.add(player11);
		players3.add(player12);
		players3.add(player13);
		players3.add(player14);
		players3.add(player15);
		
		//Insert Team
		Team team3 = new Team("URJCJAI", players3, 0, 0, 0, 0, 0, 0,"equipo3@team.com","1234");
		//teamRepository.save(team3);
		
		//Set Teams
		
		player11.setTeam(team3);
		player12.setTeam(team3);
		player13.setTeam(team3);
		player14.setTeam(team3);
		player15.setTeam(team3);

		
		Player player16 = new Player("Micael", "Gallego", Positions.Jugador, 22, null);
		Player player17 = new Player("Antonio", "Montemayor", Positions.Portero, 22, null);
		Player player18 = new Player("Julio", "Flores", Positions.Jugador, 22, null);
		Player player19 = new Player("Enrije", "Jabello", Positions.Jugador, 22, null);
		Player player20 = new Player("Alejandro", "del Amo", Positions.Jugador, 22, null);
		
		List<Player> players4 = new ArrayList<Player>();
		players4.add(player16);
		players4.add(player17);
		players4.add(player18);
		players4.add(player19);
		players4.add(player20);
		
		//Insert Team
		Team team4 = new Team("NewTeam",players4, 0, 1, 1, 1, 3, 2,"equipo1@team.com","1234");
		//teamRepository.save(team4);
		
		//Set Teams
		
		player16.setTeam(team4);
		player17.setTeam(team4);
		player18.setTeam(team4);
		player19.setTeam(team4);
		player20.setTeam(team4);

		
		Player player21 = new Player("Cristiano", "Ronaldo", Positions.Jugador, 30, null);
		Player player22 = new Player("Gareth", "Bale", Positions.Jugador, 24, null);
		Player player23 = new Player("Iker", "Casillas", Positions.Portero, 33, null);
		Player player24 = new Player("Karim", "Benzema", Positions.Jugador, 27, null);
		Player player25 = new Player("Tony", "Kroos", Positions.Jugador, 25, null);
		
		List<Player> players5 = new ArrayList<Player>();
		players5.add(player21);
		players5.add(player22);
		players5.add(player23);
		players5.add(player24);
		players5.add(player25);
		
		//Insert Team
		Team team5 = new Team("Minabo de Kiev",players5, 0, 0, 2, 0, 11, 0,"equipo5@team.com","1234");
		//teamRepository.save(team5);
		
		//Set Teams
		
		player21.setTeam(team5);
		player22.setTeam(team5);
		player23.setTeam(team5);
		player24.setTeam(team5);
		player25.setTeam(team5);
		
		
		Player player26 = new Player("Skrodan", "Mustafi", Positions.Jugador, 23, null);
		Player player27 = new Player("Nicolas", "Otamendi", Positions.Jugador, 30, null);
		Player player28 = new Player("Diego", "Alves", Positions.Portero, 30, null);
		Player player29 = new Player("Daniel", "Parejo", Positions.Jugador, 26, null);
		Player player30 = new Player("Alvaro", "Negredo", Positions.Jugador, 28, null);
		
		List<Player> players6 = new ArrayList<Player>();
		players6.add(player26);
		players6.add(player27);
		players6.add(player28);
		players6.add(player29);
		players6.add(player30);
		
		//Insert Team
		Team team6 = new Team("Aston Birras", players6, 2, 0, 0, 6, 3, 7,"equipo6@team.com","1234");
		//teamRepository.save(team6);
		
		//Set Teams
		
		player26.setTeam(team6);
		player27.setTeam(team6);
		player28.setTeam(team6);
		player29.setTeam(team6);
		player30.setTeam(team6);

		
		Player player31 = new Player("Arda", "Turan", Positions.Jugador, 28, null);
		Player player32 = new Player("Antoine", "Griezzmann", Positions.Jugador, 24, null);
		Player player33 = new Player("Jan","Oblack", Positions.Portero, 25, null);
		Player player34 = new Player("Diego", "Godin", Positions.Jugador, 29, null);
		Player player35 = new Player("Jorge", "Resurreccion", Positions.Jugador, 26, null);
		
		List<Player> players7 = new ArrayList<Player>();
		players6.add(player31);
		players6.add(player32);
		players6.add(player33);
		players6.add(player34);
		players6.add(player35);
		
		//Insert Team
		Team team7 = new Team("Pajax de Amsterdam", players7, 1, 0, 0, 3, 1, 3,"equipo7@team.com","1234");
		//teamRepository.save(team7);
		
		//Set Teams
		
		player31.setTeam(team7);
		player32.setTeam(team7);
		player33.setTeam(team7);	
		player34.setTeam(team7);
		player35.setTeam(team7);

		//Insert All Players
		
		/*playerRepository.save(players1);
		playerRepository.save(players2);
		playerRepository.save(players3);
		playerRepository.save(players4);
		playerRepository.save(players5);
		playerRepository.save(players6);
		playerRepository.save(players7);*/

		//Insert Courts
		Court court1 = new Court("Pabellon las Lomax", "Pista donde Ronaldinho comenzó su exitosa carrera","img/pabellon.jpg");
		Court court2 = new Court("Pista de Villafontana", "Pista rapida donde De Jong destrozó el pecho de Xabi","img/pabel.jpg");
		Court court3 = new Court("Pista de la URJC", "Pista en decadencia","img/pabe.jpg");
		Court court4 = new Court("Pista del Pozo Murcia", "Pista muy top donde han jugado grandes leyendas","img/pa.jpg");
		
		courtRepository.save(court1);
		courtRepository.save(court2);
		courtRepository.save(court3);
		courtRepository.save(court4);
				
		//Insert Referees
		Referee referee1 = new Referee("Luigi", "Colina","img/collina.jpg");
		Referee referee2 = new Referee("Julio", "Borbalan","img/julio.jpg");
		Referee referee3 = new Referee("Teixeira", "Vitienes","img/teixeira.jpg");
		Referee referee4 = new Referee("Sergey", "Piptukin", "img/sergey.jpeg");
		
		refereeRepository.save(referee1);
		refereeRepository.save(referee2);
		refereeRepository.save(referee3);
		refereeRepository.save(referee4);
		
		//Insert Tournaments
		
		//Insert Matches
		Match match1 = new Match (team1, team2, 4, 3);
		Match match2 = new Match (team3, team4, 1, 2);
		Match match3 = new Match (team5, team6, 0, 7);
		Match match4 = new Match (team1, team3, 2, 2);
		Match match5 = new Match (team2, team6, 2, 6);
		Match match6 = new Match (team4, team5, 1, 0);
		Match match7 = new Match (team1, team6, 0, 0);
		Match match8 = new Match (team2, team5, 3, 2);
		Match match9 = new Match (team7, team4, 10, 3);
		Match match10 = new Match (team3, team4, 10, 3);
		Match match11 = new Match (team3, team7, 10, 3);
		Match match12 = new Match (team7, team1, 3, 1);
		
		List<Team> teams1 = new ArrayList<Team>();
		
		teams1.add(team1);
		teams1.add(team2);
		teams1.add(team3);
		teams1.add(team4);
		teams1.add(team5);
		teams1.add(team6);
		teams1.add(team7);
		
		//List<Team> teams2 = new ArrayList<Team>();
		
		
		List<Match> matches1 = new ArrayList<Match>();
		
		matches1.add(match1);
		matches1.add(match2);
		matches1.add(match3);
		matches1.add(match4);
		matches1.add(match5);
		matches1.add(match6);

		List<Match> matches2 = new ArrayList<Match>();

		matches2.add(match7);
		matches2.add(match8);
		matches2.add(match9);
		matches2.add(match10);
		matches2.add(match11);
		matches2.add(match12);
		
		Tournament tournament1 = new Tournament("Copa Santiago Bernabéu","img/siiuu.jpg",teams1, matches1);
		
		//All saves
		teamRepository.save(team1);
		teamRepository.save(team2);
		teamRepository.save(team3);
		teamRepository.save(team4);
		teamRepository.save(team5);
		teamRepository.save(team6);
		teamRepository.save(team7);
		
		playerRepository.save(player1);
		playerRepository.save(player2);
		playerRepository.save(player3);
		playerRepository.save(player4);
		playerRepository.save(player5);
		playerRepository.save(player6);
		playerRepository.save(player7);
		playerRepository.save(player8);
		playerRepository.save(player9);
		playerRepository.save(player10);
		playerRepository.save(player11);
		playerRepository.save(player12);
		playerRepository.save(player13);
		playerRepository.save(player14);
		playerRepository.save(player15);
		playerRepository.save(player16);
		playerRepository.save(player17);
		playerRepository.save(player18);
		playerRepository.save(player19);
		playerRepository.save(player20);
		playerRepository.save(player21);
		playerRepository.save(player22);
		playerRepository.save(player23);
		playerRepository.save(player24);
		playerRepository.save(player25);
		playerRepository.save(player26);
		playerRepository.save(player27);
		playerRepository.save(player28);
		playerRepository.save(player29);
		playerRepository.save(player30);
		playerRepository.save(player31);
		playerRepository.save(player32);
		playerRepository.save(player33);
		playerRepository.save(player34);
		playerRepository.save(player35);
		

		
		courtRepository.save(court1);
		courtRepository.save(court2);
		courtRepository.save(court3);
		courtRepository.save(court4);
		
		refereeRepository.save(referee1);
		refereeRepository.save(referee2);
		refereeRepository.save(referee3);
		refereeRepository.save(referee4);
	
		
		matchRepository.save(match1);
		matchRepository.save(match2);
		matchRepository.save(match3);
		matchRepository.save(match4);
		matchRepository.save(match5);
		matchRepository.save(match6);
		matchRepository.save(match7);
		matchRepository.save(match8);
		matchRepository.save(match9);
		matchRepository.save(match10);
		matchRepository.save(match11);
		
		
		tournamentRepository.save(tournament1);

	}
}
