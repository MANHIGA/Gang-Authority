package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;

@Entity
@Table(name = "Combattre")
public class Combattre implements Serializable {

	@Id
	@OneToOne
	@JoinColumn(name = "idCompte")
	private Joueur attaquant;

	@Id
	@OneToOne
	@JoinColumn(name = "idCompte")
	private Joueur defenseur;

	@Column(name = "nbSbiresEnvoyesPvp")
	private Integer nbSbiresEnvoyesPvp;

	@Id
	@Column(name = "datePvp")
	private Date datePvp;

	public Combattre() {
	}

	public Combattre(Joueur attaquant, Joueur defenseur,
			Integer nbSbiresEnvoyesPvp, Date datePvp) {
		super();
		this.attaquant = attaquant;
		this.defenseur = defenseur;
		this.nbSbiresEnvoyesPvp = nbSbiresEnvoyesPvp;
		this.datePvp = datePvp;
	}

	public Joueur getAttaquant() {
		return attaquant;
	}

	public void setAttaquant(Joueur attaquant) {
		this.attaquant = attaquant;
	}

	public Joueur getDefenseur() {
		return defenseur;
	}

	public void setDefenseur(Joueur defenseur) {
		this.defenseur = defenseur;
	}

	public Integer getNbSbiresEnvoyesPvp() {
		return nbSbiresEnvoyesPvp;
	}

	public void setNbSbiresEnvoyesPvp(int nbSbiresEnvoyesPvp) {
		this.nbSbiresEnvoyesPvp = nbSbiresEnvoyesPvp;
	}

	public Date getDatePvp() {
		return datePvp;
	}

	public void setDatePvp(Date datePvp) {
		this.datePvp = datePvp;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Combattre) {
			Combattre c = (Combattre) o;
			if ((attaquant.getIdCompte() == c.getAttaquant().getIdCompte())
					&& (defenseur.getIdCompte() == c.getDefenseur()
							.getIdCompte())) {
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
		return attaquant.hashCode() + defenseur.hashCode() + datePvp.hashCode();
	}

	public void majPointsAttaques() {

		Session s = AppFactory.getSessionFactory().openSession();
		
		//int pointsAttaque = nbSbiresEnvoyesPvp * attaquant.getSbires().get;
		
		s.close();
	}

	public void majPointsDefense() {
		Session s = AppFactory.getSessionFactory().openSession();

		s.close();
	}
}
