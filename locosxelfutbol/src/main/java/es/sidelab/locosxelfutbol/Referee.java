package es.sidelab.locosxelfutbol;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Referee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8657278808944294842L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private String name;
	private String lastName;
	private String image;

	public Referee() {
	}

	public Referee(String name, String lastName, String image) {
		this.name = name;
		this.lastName = lastName;
		this.image=image;
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
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
