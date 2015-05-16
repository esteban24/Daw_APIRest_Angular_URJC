package es.sidelab.locosxelfutbol;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;	
	private String name;
	private String lastName;
	private String position;
	private int age;
	private Team team;

	public Player(){
		this.name="";
		this.lastName="";
		this.position="";
		this.age=0;
		this.team= new Team();
	}

	public Player(String name, String lastName, String position, int age, Team team) {
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
		this.team = team;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", Nombre=" + name + ", Apellido=" + lastName
				+ ", Posicion=" + position + ", Edad=" + age + ", Equipo=" + team +"]";
	}

}
