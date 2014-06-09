/**
 * 
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Entrainer")
public class Entrainer {
	
	@OneToOne
	@Column(name="entrainer_idCompte")
	private Joueur joueur;
	
	@OneToOne
	@Column(name="entrainer_typeSbire")
	private TypeSbire typeSbire;
	
	@Column(name="nbSbire")
	private int nbSbire;
	
	@Column(name="pointAttaque")
	private int pointAttaque;
	
	@Column(name="pointDefense")
	private int pointDefense;

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public TypeSbire getTypeSbire() {
		return typeSbire;
	}

	public void setTypeSbire(TypeSbire typeSbire) {
		this.typeSbire = typeSbire;
	}

	public int getNbSbire() {
		return nbSbire;
	}

	public void setNbSbire(int nbSbire) {
		this.nbSbire = nbSbire;
	}

	public int getPointAttaque() {
		return pointAttaque;
	}

	public void setPointAttaque(int pointAttaque) {
		this.pointAttaque = pointAttaque;
	}

	public int getPointDefense() {
		return pointDefense;
	}

	public void setPointDefense(int pointDefense) {
		this.pointDefense = pointDefense;
	}
}
