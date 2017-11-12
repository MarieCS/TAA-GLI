package sample.data.jpa.domain;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Sport {

	long id;
	String name;
	Collection<TypeTerrain> terrainsPossibles;

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

	@ElementCollection(targetClass = TypeTerrain.class)
	@CollectionTable(name = "terrain_possible")
//	@Column(name = "type_terrain") // Column name in person_interest
	public Collection<TypeTerrain> getTerrainsPossibles() {
		return terrainsPossibles;
	}

	public void setTerrainsPossibles(Collection<TypeTerrain> terrainsPossibles) {
		this.terrainsPossibles = terrainsPossibles;
	}
}
