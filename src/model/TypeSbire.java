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
@Table(name="TypeSbire")
public class TypeSbire {
	
	@Id
	@GeneratedValue
	@Column(name="idTypeSbire")
    private int idTypeSbire;
	
	@Column(name="libelleTypeSbire")
    private String libelleTypeSbire;
	
	@Column(name="cout")
    private int cout;
	
	@Column(name="tempsApparition")
    private int tempsApparition;
	
	@OneToOne
	@Column(name="TypeSbire_idTypeBatiment")
	private TypeBatiment typeBatiment;

	public int getIdTypeSbire() {
		return idTypeSbire;
	}

	public String getLibelleTypeSbire() {
		return libelleTypeSbire;
	}

	public int getCout() {
		return cout;
	}

	public int getTempsApparition() {
		return tempsApparition;
	}

	public TypeBatiment getTypeBatiment() {
		return typeBatiment;
	}

	public void setTypeBatiment(TypeBatiment typeBatiment) {
		this.typeBatiment = typeBatiment;
	}
}
