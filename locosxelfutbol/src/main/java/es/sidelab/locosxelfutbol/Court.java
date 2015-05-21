package es.sidelab.locosxelfutbol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Court{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;	
	private String name;
	private String description;
	private String image;


	public Court() {
	}

	public Court(String name, String description, String image) {
		this.name = name;
		this.description = description;
		this.image= image;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Nombre=" + name;
	}

}
