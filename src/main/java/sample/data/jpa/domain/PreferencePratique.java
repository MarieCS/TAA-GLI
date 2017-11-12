package sample.data.jpa.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="preference")
public class PreferencePratique {

	long id;

	double temperateureMin;
	double temperateureMax;

	int vitesseVentMin;
	int vitesseVentMax;

	int hauteurVagueMin;
	int HauteurVagueMax;

	int couvertureNuageuseMax;
		

	@Column(nullable = true)
	public double getTemperateureMin() {
		return temperateureMin;
	}

	public void setTemperateureMin(double temperateureMin) {
		this.temperateureMin = temperateureMin;
	}

	@Column(nullable = true)
	public double getTemperateureMax() {
		return temperateureMax;
	}

	public void setTemperateureMax(double temperateureMax) {
		this.temperateureMax = temperateureMax;
	}

	@Column(nullable = true)
	public int getVitesseVentMin() {
		return vitesseVentMin;
	}

	public void setVitesseVentMin(int vitesseVentMin) {
		this.vitesseVentMin = vitesseVentMin;
	}

	@Column(nullable = true)
	public int getVitesseVentMax() {
		return vitesseVentMax;
	}

	public void setVitesseVentMax(int vitesseVentMax) {
		this.vitesseVentMax = vitesseVentMax;
	}

	@Column(nullable = true)
	public int getHauteurVagueMin() {
		return hauteurVagueMin;
	}

	public void setHauteurVagueMin(int hauteurVagueMin) {
		this.hauteurVagueMin = hauteurVagueMin;
	}

	@Column(nullable = true)
	public int getHauteurVagueMax() {
		return HauteurVagueMax;
	}

	public void setHauteurVagueMax(int hauteurVagueMax) {
		HauteurVagueMax = hauteurVagueMax;
	}

	@Column(nullable = true)
	public int getCouvertureNuageuse() {
		return couvertureNuageuseMax;
	}

	public void setCouvertureNuageuse(int couvertureNuageuse) {
		this.couvertureNuageuseMax = couvertureNuageuse;
	}

	public int getCouvertureNuageuseMax() {
		return couvertureNuageuseMax;
	}

	public void setCouvertureNuageuseMax(int couvertureNuageuseMax) {
		this.couvertureNuageuseMax = couvertureNuageuseMax;
	}

	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
}
