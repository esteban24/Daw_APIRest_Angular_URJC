package es.sidelab.locosxelfutbol;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Court{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private int name;
	private Calendar schedule; 

	public Court() {
	}

	public Court(int name, Calendar calendar) {
		this.name = name;
		calendar= Calendar.getInstance();
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public Calendar getSchedule() {
		return schedule;
	}

	public void setSchedule(Calendar schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		return "Nombre=" + name;
	}

}
