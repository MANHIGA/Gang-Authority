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
@Table(name = "Concerner")
public class Concerner implements Serializable {
	
	@Id
	@OneToOne
	@JoinColumn(name = "Concerner_idSignalement")
	private Signalement idSignalement;
	
	@Id
	@OneToOne
	@JoinColumn(name = "Concerner_idCompte")
	private Joueur idCompte;
	
	public Concerner(){
		
	}

	public Signalement getIdSignalement() {
		return idSignalement;
	}

	public void setIdSignalement(Signalement idSignalement) {
		this.idSignalement = idSignalement;
	}

	public Joueur getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Joueur idCompte) {
		this.idCompte = idCompte;
	}
	
	public Concerner(Signalement idSignalement, Joueur idCompte) {
		super();
		this.idSignalement = idSignalement;
		this.idCompte = idCompte;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Concerner) {
			Concerner c = (Concerner) o;
			if ((idSignalement.getIdSignalement() == c.getIdSignalement().getIdSignalement())
					&& (idCompte.getIdCompte() == c.getIdCompte().getIdCompte()
							)) {
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
		return idSignalement.hashCode() + idCompte.hashCode();
	}

}
