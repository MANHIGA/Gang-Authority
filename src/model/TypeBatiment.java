/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;

import javax.persistence.*;

/**
 *
 * @author Rems
 */

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
    
    public void setLibelleTypeBatiment(String libelle){
    	libelleTypeBatiment = libelle;
    }
    
    public void setTempsCreationBatiment(int temps){
    	tempsCreationBatiment = temps;
    }
    
    
}
