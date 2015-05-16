package es.sidelab.locosxelfutbol;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;	
	private String name;
	private ArrayList<Player> players;
	private int win;
	private int draw;
	private int defeat;
	private int points;
	private int gc;
	private int gf;

	public Team() {
		this.name="";
		this.players= new ArrayList<Player>();
		this.win=0;
		this.draw=0;
		this.defeat=0;
		this.points=0;
		this.gc=0;
		this.gf=0;
	}

	public Team(String name, ArrayList<Player> players, int win, int draw, int defeat, int points, int gc, int gf) {
		this.name = name;
		this.players= players;
		this.win=win;
		this.draw=draw;
		this.defeat=defeat;
		this.gc=gc;
		this.gf=gf;
	}	
	
	public void calculatePoints(int win, int draw, int defeat){
		int pointsnew= (win*3)+draw;
		this.setPoints(pointsnew);
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

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
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

	@Override
	public String toString() {
		return name;
	}

}