/**
 * 
 */
package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Realiser")
public class Realiser implements Serializable{
	
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
	
	public Realiser(){}

	public Realiser(Joueur joueur, Mission mission, Date dateRealisation,
			Integer nbSbiresEnvoyesRealisation) {
		super();
		this.joueur = joueur;
		this.mission = mission;
		this.dateRealisation = dateRealisation;
		this.nbSbiresEnvoyesRealisation = nbSbiresEnvoyesRealisation;
	}

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
	
	@Override
	public boolean equals(Object o){
		if(o instanceof Realiser){
			Realiser r = (Realiser) o;
			if((joueur == r.getJoueur()) && (mission == r.getMission())){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return joueur.hashCode() + mission.hashCode();
	}
}
