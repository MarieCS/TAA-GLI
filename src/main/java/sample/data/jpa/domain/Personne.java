package sample.data.jpa.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Personne {

	long id;
	String name;
	String mail;
	Map<Sport, PreferencePratique> preferences;
	Collection<Lieu> lieux;

	public Personne() {
		preferences = new HashMap<Sport, PreferencePratique>();
		lieux = new ArrayList<Lieu>();
	}

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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@ManyToMany(cascade = CascadeType.ALL)
	public Map<Sport, PreferencePratique> getPreferences() {
		return preferences;
	}

	public void setPreferences(Map<Sport, PreferencePratique> preferences) {
		this.preferences = preferences;
	}

	@ElementCollection(targetClass = Lieu.class)
	@CollectionTable(name = "lieux_preferes")
	@OneToMany
	public Collection<Lieu> getLieux() {
		return lieux;
	}

	public void setLieux(Collection<Lieu> lieux) {
		this.lieux = lieux;
	}

}
