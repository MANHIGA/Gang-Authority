/**
 * 
 */
package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Realiser")
public class Realiser {
	
	@OneToOne
	@Column(name="realiser_idCompte")
	private Joueur joueur;
	
	@OneToOne
	@Column(name="realiser_idMission")
	private Mission mission;
	
	@Column(name="dateRealisation")
	private Date dateRealisation;
	
	@Column(name="nbSbiresEnvoyesRealisation")
	private int nbSbiresEnvoyesRealisation;

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public Mission getMission() {
		return mission;
	}

	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public Date getDateRealisation() {
		return dateRealisation;
	}

	public void setDateRealisation(Date dateRealisation) {
		this.dateRealisation = dateRealisation;
	}

	public int getNbSbiresEnvoyesRealisation() {
		return nbSbiresEnvoyesRealisation;
	}

	public void setNbSbiresEnvoyesRealisation(int nbSbiresEnvoyesRealisation) {
		this.nbSbiresEnvoyesRealisation = nbSbiresEnvoyesRealisation;
	}
}
