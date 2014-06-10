/**
 * 
 */
package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Entrainer")
public class Entrainer implements Serializable{

	@Id
	@OneToOne
	@JoinColumn(name="entrainer_idCompte")
	private Joueur joueur;
	
	@Id
	@OneToOne
	@JoinColumn(name="entrainer_typeSbire")
	private TypeSbire typeSbire;
	
	@Column(name="nbSbire")
	private Integer nbSbire;
	
	@Column(name="pointAttaque")
	private Integer pointAttaque;
	
	@Column(name="pointDefense")
	private Integer pointDefense;

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

	public Integer getNbSbire() {
		return nbSbire;
	}

	public void setNbSbire(Integer nbSbire) {
		this.nbSbire = nbSbire;
	}

	public Integer getPointAttaque() {
		return pointAttaque;
	}

	public void setPointAttaque(Integer pointAttaque) {
		this.pointAttaque = pointAttaque;
	}

	public Integer getPointDefense() {
		return pointDefense;
	}

	public void setPointDefense(Integer pointDefense) {
		this.pointDefense = pointDefense;
	}
	
	@Override
	public boolean equals(Object o){
		Entrainer e = (Entrainer) o;
		if((joueur.getIdCompte() == e.getJoueur().getIdCompte()) && (typeSbire.getIdTypeSbire() == e.getTypeSbire().getIdTypeSbire())){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public int hashCode(){
		return joueur.getIdCompte().hashCode() + typeSbire.getIdTypeSbire().hashCode();
	}
}
