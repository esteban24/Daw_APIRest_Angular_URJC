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
	//TODO emartin: Cambiado Temam local y Team visitant por String provisionalmente
	private String local;
	private String visitant;
	private int goalsLocal;
	private int goalsVisitant;
	
	public Match(){
		this.local= "";
		this.visitant= "";
		this.goalsLocal=0;
		this.goalsVisitant=0;
	}

	public Match(String local, String visitant, int goalsLocal, int goalsVisitant){
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

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getVisitant() {
		return visitant;
	}

	public void setVisitant(String visitant) {
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
