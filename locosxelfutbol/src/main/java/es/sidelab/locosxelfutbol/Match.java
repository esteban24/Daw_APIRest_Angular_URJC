package es.sidelab.locosxelfutbol;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Match {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;	
	private Team local;
	private Team visitant;
	private int goalsLocal;
	private int goalsVisitant;
	
	public Match(){
		this.local= new Team();
		this.visitant= new Team();
		this.goalsLocal=0;
		this.goalsVisitant=0;
	}

	public Match(Team local, Team visitant, int goalsLocal, int goalsVisitant){
		this.local= local;
		this.visitant= visitant;
		this.goalsLocal= goalsLocal;
		this.goalsVisitant= goalsVisitant;
	}
		
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Team getLocal() {
		return local;
	}

	public void setLocal(Team local) {
		this.local = local;
	}

	public Team getVisitant() {
		return visitant;
	}

	public void setVisitant(Team visitant) {
		this.visitant = visitant;
	}

	public int getGoalsLocal() {
		return goalsLocal;
	}

	public void setGoalsLocal(int goalsLocal) {
		this.goalsLocal = goalsLocal;
	}

	public int getGoalsVisitant() {
		return goalsVisitant;
	}

	public void setGoalsVisitant(int goalsVisitant) {
		this.goalsVisitant = goalsVisitant;
	}

	/*@Override
	public String toString() {
		return name;
	}*/


}
