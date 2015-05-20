package es.sidelab.locosxelfutbol;
import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Player implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1171515667236399734L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private String name;
	private String lastName;
	private Positions position;
	private int age;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="TEAM")
	private Team team;
	//private String team;

	public Player(){
		this.name="";
		this.lastName="";
		this.position = Positions.Jugador;
		this.age=0;
		this.team= null;
	}

	public Player(String name, String lastName, Positions position, int age, Team team) {
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
		this.team = team;
	}
	
	/*public Player(String name, String lastName, Positions position, int age, String team) {
		this.name = name;
		this.lastName = lastName;
		this.position = position;
		this.age = age;
		this.team = team;
	}*/
	
	public void setTeam(Team team) {
        setTeam(team, true);
    }
	
     
    void setTeam(Team team, boolean add) {
        this.team = team;
        if (team != null && add) {
            team.addPlayer(this, false);
        }
    }
 

    public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof Player))
            return false;
 
        final Player player = (Player)object;
 
        if (id != null && player.getId() != null) {
            return id.equals(player.getId());
        }
        return false;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Positions getPosition() {
		return position;
	}

	public void setPosition(Positions position) {
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
	
	/*public String getTeam() {
		return team;
	}*/

	/*public void setTeam(Team team) {
		this.team = team;
	}*/
	
	/*public void setTeam(String team) {
		this.team = team;
	}*/

}
