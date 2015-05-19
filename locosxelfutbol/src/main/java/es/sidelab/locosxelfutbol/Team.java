package es.sidelab.locosxelfutbol;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import es.sidelab.locosxelfutbol.Player;

@Entity
public class Team{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private String name;
	@OneToMany(mappedBy="team")
	private List<Player> players;
	private int win;
	private int draw;
	private int defeat;
	private int points;
	private int gc;
	private int gf;

	public Team() {
		this.name="";
		this.players= null;
		this.win=0;
		this.draw=0;
		this.defeat=0;
		this.points=0;
		this.gc=0;
		this.gf=0;
	}

	public Team(String name, List<Player> players, int win, int draw, int defeat, int points, int gc, int gf) {
		this.name = name;
		this.players= players;
		this.win=win;
		this.draw=draw;
		this.defeat=defeat;
		this.gc=gc;
		this.gf=gf;
	}	
	
	public void addPlayer(Player player) {
        addPlayer(player, true);
    }
	
	void addPlayer(Player player, boolean set) {
        if (player != null) {
            if(this.getPlayers().contains(player)) {
                getPlayers().set(getPlayers().indexOf(player), player);
            }
            else {
                getPlayers().add(player);
            }
            if (set) {
                player.setTeam(this, false);
            }
        }
    }
	
	public void removePlayer(Player player) {
        getPlayers().remove(player);
        player.setA(null);
    }    
 
     
	public boolean equals(Object object) {
        if (object == this)
            return true;
        if ((object == null) || !(object instanceof Team))
            return false;
 
        final Team team = (Team)object;
 
        if (this.getId() != null && team.getId() != null) {
            return id.equals(team.getId());
        }
        return false;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public Long getId() {
        return id;
    }
	
	public void refreshPoints(int win, int draw, int defeat){
		int pointsnew= (win*3)+draw;
		this.setPoints(pointsnew);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade={CascadeType.ALL})
	public List<Player> getPlayers() {
		return players;
	}

	@OneToMany(cascade={CascadeType.ALL})
	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getDefeat() {
		return defeat;
	}

	public void setDefeat(int defeat) {
		this.defeat = defeat;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getGc() {
		return gc;
	}

	public void setGc(int gc) {
		this.gc = gc;
	}

	public int getGf() {
		return gf;
	}

	public void setGf(int gf) {
		this.gf = gf;
	}

}