package sample.data.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeTerrain {
	
	long id;

//	terrestre, montagneux, plage, lac, riviere, mer, foret, champ
	String nom;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
