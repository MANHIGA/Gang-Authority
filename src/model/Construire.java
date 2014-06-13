package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Construire")
public class Construire implements Serializable{
	
	@Id
	@ManyToOne
	@JoinColumn(name="Construire_idCompte")
    private Joueur joueur;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Construire_idTypeBatiment")
    private TypeBatiment typeBatiment;
	
	@Column(name="niveau")
    private Integer niveau;
	
	@Column(name="populationMax")
    private Integer populationMax;

	public Construire(Joueur joueur, TypeBatiment typeBatiment, Integer niveau, Integer populationMax) {
		super();
		this.joueur = joueur;
		this.typeBatiment = typeBatiment;
		this.niveau = niveau;
		this.populationMax = populationMax;
	}
	
	public Construire(){}
	
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
