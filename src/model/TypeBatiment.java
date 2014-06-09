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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TypeBatiment")
public class TypeBatiment {
	
	@Id
	@GeneratedValue
	@Column(name="idTypeBatiment")
    private int idTypeBatiment;
	
    
    @Column(name="libelleTypeBatiment")
    private String libelleTypeBatiment;
    
    @Column(name="tempsCreationBatiment")
    private int tempsCreationBatiment;
    
    @OneToOne
    @Column(name="TypeBatiment_idTypeSbire")
    private TypeSbire typeSbire;

	public int getIdTypeBatiment() {
		return idTypeBatiment;
	}

	public void setIdTypeBatiment(int idTypeBatiment) {
		this.idTypeBatiment = idTypeBatiment;
	}

	public String getLibelleTypeBatiment() {
		return libelleTypeBatiment;
	}

	public void setLibelleTypeBatiment(String libelleTypeBatiment) {
		this.libelleTypeBatiment = libelleTypeBatiment;
	}

	public int getTempsCreationBatiment() {
		return tempsCreationBatiment;
	}

	public void setTempsCreationBatiment(int tempsCreationBatiment) {
		this.tempsCreationBatiment = tempsCreationBatiment;
	}

	public TypeSbire getTypeSbire() {
		return typeSbire;
	}

	public void setTypeSbire(TypeSbire typeSbire) {
		this.typeSbire = typeSbire;
	}
    
    
    
    
}
