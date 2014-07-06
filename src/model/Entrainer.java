package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.Transaction;


@Entity
@Table(name="Entrainer")
public class Entrainer implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="entrainer_idCompte")
	private Joueur joueur;
	
	@Id
	@ManyToOne
	@JoinColumn(name="entrainer_idtypeSbire")
	private TypeSbire typeSbire;
	
	@Column(name="nbSbire")
	private Integer nbSbire;
	
	@Column(name="pointAttaque")
	private Integer pointAttaque;
	
	@Column(name="pointDefense")
	private Integer pointDefense;
	
	public Entrainer(){}

	public Entrainer(Joueur joueur, TypeSbire typeSbire) {
		super();
		this.joueur = joueur;
		this.typeSbire = typeSbire;
		this.nbSbire = 1;
		this.pointAttaque = 100;
		this.pointDefense = 100;
	}

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
		Session s = AppFactory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
			this.nbSbire += nbSbire;
		s.update(this);	
		tx.commit();
		s.close();
	}

	public Integer getPointAttaque() {
		return pointAttaque;
	}

	public void setPointAttaque(Integer pointAttaque) {
		Session s = AppFactory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();		
		this.pointAttaque = pointAttaque;
		s.update(this);	
		tx.commit();
		s.close();
	}

	public Integer getPointDefense() {
		return pointDefense;
	}

	public void setPointDefense(Integer pointDefense) {
		Session s = AppFactory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();	
			this.pointDefense = pointDefense;
		s.update(this);	
		tx.commit();
		s.close();
	}
	
	@Override
	public boolean equals(Object o){
		if((o instanceof Entrainer)){
			Entrainer e = (Entrainer) o;
			if((joueur == e.getJoueur()) && (typeSbire == e.getTypeSbire())){
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
		return joueur.hashCode() + typeSbire.hashCode();
	}
}
