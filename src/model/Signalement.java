package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Signalement")
public class Signalement implements Serializable{
	
	@Id
	@GeneratedValue
	@Column(name="idSignalement")
	private Integer idSignalement;
	
	@Id
	@OneToOne
	@JoinColumn(name="Signalement_idCompte")
	private Joueur joueur;

	@Column(name="justification")
	private String justification;
	
	@Column(name="dateSignalement")
	private Date dateSignalement;
	
	public Signalement(){}
	
	public Signalement(Joueur j, String raison){
		this.joueur = j;
		this.justification = raison;
	}
	
	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
	public Integer getIdSignalement() {
		return idSignalement;
	}

	public void setIdSignalement(Integer idSignalement) {
		this.idSignalement = idSignalement;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public Date getDateSignalement() {
		return dateSignalement;
	}

	public void setDateSignalement(Date dateSignalement) {
		this.dateSignalement = dateSignalement;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Signalement) {
			Signalement s = (Signalement) o;
			if (this.getIdSignalement() == s.getIdSignalement()){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return joueur.hashCode();
	}
}
