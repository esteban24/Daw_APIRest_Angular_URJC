package es.sidelab.locosxelfutbol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tournament{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private String name;
/*	@OneToMany
	@JoinTable(name="TOURN_TEAM",
	joinColumns=@JoinColumn(name="TEAM_ID"),
	inverseJoinColumns=@JoinColumn(name="TOURNT_ID"))
	private List<Team> teams;*/
	private String teams;
/*	@OneToMany
	@JoinTable(name="TOURN_MATCH",
	joinColumns=@JoinColumn(name="MATCH_ID"),
	inverseJoinColumns=@JoinColumn(name="TOURNM_ID"))
	private List<Match> matches;*/
	//private String matches;
	
	public Tournament(){
		this.name="";
		this.teams= "";
		//this.matches= "";
	}
	
	public Tournament(String name, String teams){
		this.name=name;
		this.teams=teams;
		//this.matches=matchs;
	}

	
	/*public void playMatch(Team local, Team visitant, int goalsLocal, int goalsVisitant){
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
	}*/
	
	
	public String getName() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getTeams() {
		return teams;
	}
	
	public void setTeams(String teams) {
		this.teams = teams;
	}
	
	/*public String getMatches() {
		return matches;
	}

	public void setMatches(String matches) {
		this.matches = matches;
	}*/
	
	

}
