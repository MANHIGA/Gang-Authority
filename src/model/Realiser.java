/**
 * 
 */
package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Realiser")
public class Realiser {
	
	@Id
	@OneToOne
	@JoinColumn(name="realiser_idCompte")
	private Joueur joueur;
	
	@Id
	@OneToOne
	@JoinColumn(name="realiser_idMission")
	private Mission mission;
	
	@Column(name="dateRealisation")
	private Date dateRealisation;
	
	@Column(name="nbSbiresEnvoyesRealisation")
	private Integer nbSbiresEnvoyesRealisation;

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

	public Integer getNbSbiresEnvoyesRealisation() {
		return nbSbiresEnvoyesRealisation;
	}

	public void setNbSbiresEnvoyesRealisation(int nbSbiresEnvoyesRealisation) {
		this.nbSbiresEnvoyesRealisation = nbSbiresEnvoyesRealisation;
	}
}
