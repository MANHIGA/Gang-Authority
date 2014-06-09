/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.sql.Date;

@Entity
@Table(name="Combattre")
public class Combattre {
	
	@Column(name="attaquant")
	@ManyToOne
	@JoinColumn(name="idCompte")
    private Joueur attaquant;
	
	@Column(name="defenseur")
	@ManyToOne
	@JoinColumn(name="idCompte")
    private Joueur defenseur;
	
	@Column(name="nbSbiresEnvoyesPvp")
    private int nbSbiresEnvoyesPvp;
	
	@Column(name="datePvp")
    private Date datePvp;
	
	public int getNbSbiresEnvoyesPvp(){
		return nbSbiresEnvoyesPvp;
	}
	
	public void setNbSbiresEnvoyesPvp(int nb){
		nbSbiresEnvoyesPvp = nb;
	}
	
}
