package es.sidelab.locosxelfutbol;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Tournament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;	
	private String name;
	private ArrayList<Team> teams;
	private ArrayList<Match> matchs;
	
	public Tournament(){
		this.name="";
		this.teams= new ArrayList<Team>();
		this.matchs= new ArrayList<Match>();
	}
	
	public Tournament(String name, ArrayList<Team> teams, ArrayList<Match> matchs){
		this.name=name;
		this.teams=teams;
		this.matchs=matchs;
	}
	
	public void playMatch(Team local, Team visitant, int goalsLocal, int goalsVisitant){
		local.setGf(goalsLocal);
		local.setGc(goalsVisitant);
		visitant.setGf(goalsVisitant);
		visitant.setGc(goalsLocal);
		if (goalsLocal==goalsVisitant){
			local.setDraw(local.getDraw()+1);
			visitant.setDraw(visitant.getDraw()+1);
			local.refreshPoints(local.getWin(), local.getDraw(), local.getDefeat());
			local.refreshPoints(visitant.getWin(), visitant.getDraw(), visitant.getDefeat());
		}else if (goalsLocal>goalsVisitant){
			local.setWin(local.getWin()+1);
			visitant.setDefeat(visitant.getDefeat()+1);
			local.refreshPoints(local.getWin(), local.getDraw(), local.getDefeat());
			local.refreshPoints(visitant.getWin(), visitant.getDraw(), visitant.getDefeat());
		}else if (goalsLocal<goalsVisitant){
			visitant.setWin(local.getWin()+1);
			local.setDefeat(visitant.getDefeat()+1);
			local.refreshPoints(local.getWin(), local.getDraw(), local.getDefeat());
			local.refreshPoints(visitant.getWin(), visitant.getDraw(), visitant.getDefeat());
		}
	}

}
