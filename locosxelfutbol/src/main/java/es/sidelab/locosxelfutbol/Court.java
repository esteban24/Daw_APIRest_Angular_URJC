package es.sidelab.locosxelfutbol;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Court {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long id;	
	private int name;
	private GregorianCalendar schedule; 

	public Court() {
	}

	public Court(int name, GregorianCalendar schedule) {
		this.name = name;
		schedule= new GregorianCalendar();
	}	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public GregorianCalendar getSchedule() {
		return schedule;
	}

	public void setSchedule(GregorianCalendar schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Nombre=" + name;
	}

}
