package es.sidelab.locosxelfutbol;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Game{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	@OneToOne
	private Team local;
	@OneToOne
	private Team visitant;
	private int goalsLocal;
	private int goalsVisitant;
	
	public Game(){
		this.local= null;
		this.visitant= null;
		this.goalsLocal=0;
		this.goalsVisitant=0;
	}

	public Game(Team local, Team visitant, int goalsLocal, int goalsVisitant){
		this.local= local;
		this.visitant= visitant;
		this.goalsLocal= goalsLocal;
		this.goalsVisitant= goalsVisitant;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
