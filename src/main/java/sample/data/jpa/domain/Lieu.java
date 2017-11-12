package sample.data.jpa.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Lieu {

	long id;
	String name;
	String codePostal;
	long lat;
	long lon;
	Collection<TypeTerrain> terrains;

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getLat() {
		return lat;
	}

	public void setLat(long lat) {
		this.lat = lat;
	}

	public long getLon() {
		return lon;
	}

	public void setLon(long lon) {
		this.lon = lon;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/*
	 * //TODO @ de l'enum class //TODO @ de cet attribut public
	 * Collection<TypeTerrain> getTerrains() { return terrains; }
	 * 
	 * public void setTerrains(Collection<TypeTerrain> terrains) { this.terrains =
	 * terrains; }
	 */

}
