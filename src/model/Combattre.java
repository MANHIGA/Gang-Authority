/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Combattre")
public class Combattre {
	
	@Id
	@OneToOne
	@JoinColumn(name="idCompte")
    private Joueur attaquant;
	
	@Id
	@OneToOne
	@JoinColumn(name="idCompte")
    private Joueur defenseur;
	
	@Column(name="nbSbiresEnvoyesPvp")
    private Integer nbSbiresEnvoyesPvp;
	
	@Column(name="datePvp")
    private Date datePvp;

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
	
	
}
