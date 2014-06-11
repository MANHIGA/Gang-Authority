/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Construire")
public class Construire implements Serializable{
	
	@Id
	@OneToOne
    private Joueur joueur;
	
	@Id
	@OneToOne
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
	
	@Override
	public boolean equals(Object o){
		
		if(o == null){
			return false;
		}	
		
		if(!(o instanceof Construire)){
			return false;
		}
		
		Construire c = (Construire) o ;
		
		if(this.getJoueur().getIdCompte() == c.getJoueur().getIdCompte() && this.getTypeBatiment().getIdTypeBatiment() == c.getTypeBatiment().getIdTypeBatiment()){
			return true;
		}
		
		if(this == c){
			return true;
		}		
			
		return false;
	}
	
	@Override
	public int hashCode(){
		return joueur.hashCode() + typeBatiment.hashCode();
	}
}
