/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Construire")
public class Construire {
	
	@OneToOne
	@Column(name="contruire_idCompte")
    private Joueur joueur;
	
	@OneToOne
	@Column(name="construire_typeBatiment")
    private TypeBatiment typeBatiment;
	
	@Column(name="niveau")
    private Integer niveau;
	
	@Column(name="populationMax")
    private Integer populationMax;

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public TypeBatiment getTypeBatiment() {
		return typeBatiment;
	}

	public void setTypeBatiment(TypeBatiment typeBatiment) {
		this.typeBatiment = typeBatiment;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}

	public Integer getPopulationMax() {
		return populationMax;
	}

	public void setPopulationMax(int populationMax) {
		this.populationMax = populationMax;
	}
	
	public boolean equals(Construire c){
		
		if(this == c){
			return true;
		}
		if(c == null){
			return false;
		}
		
		
		return false;
	}
}
