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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TypeBatiment")
public class TypeBatiment {
	
	@Id
	@GeneratedValue
	@Column(name="idTypeBatiment")
    private Integer idTypeBatiment;
	
    
    @Column(name="libelleTypeBatiment")
    private String libelleTypeBatiment;
    
    @Column(name="tempsCreationBatiment")
    private Integer tempsCreationBatiment;
    
    @OneToOne
    @JoinColumn(name="TypeBatiment_idTypeSbire")
    private TypeSbire typeSbire;

	public TypeBatiment(String libelleTypeBatiment,Integer tempsCreationBatiment, TypeSbire typeSbire) {
		super();
		this.libelleTypeBatiment = libelleTypeBatiment;
		this.tempsCreationBatiment = tempsCreationBatiment;
		this.typeSbire = typeSbire;
	}

	public Integer getIdTypeBatiment() {
		return idTypeBatiment;
	}

	public String getLibelleTypeBatiment() {
		return libelleTypeBatiment;
	}

	public Integer getTempsCreationBatiment() {
		return tempsCreationBatiment;
	}

	public TypeSbire getTypeSbire() {
		return typeSbire;
	}
    
    
    
    
    
}
