/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;


/**
 *
 * @author Rems
 */
public class Joueur {
	
	
    private int idCompte;
    private String pseudo;
    private String email;
    private String mdp;
    private int pointsAutorite;
    private int nbMorts;
    private int nbTues;
    private int argent;
    private String nomGang;
    
	public int getIdCompte() {
		return idCompte;
	}
	
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}
	
	public String getPseudo() {
		return pseudo;
	}
	
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMdp() {
		return mdp;
	}
	
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	
	public int getPointsAutorite() {
		return pointsAutorite;
	}
	
	public void setPointsAutorite(int pointsAutorite) {
		this.pointsAutorite = pointsAutorite;
	}
	
	public int getNbMorts() {
		return nbMorts;
	}
	
	public void setNbMorts(int nbMorts) {
		this.nbMorts = nbMorts;
	}
	
	public int getNbTues() {
		return nbTues;
	}
	
	public void setNbTues(int nbTues) {
		this.nbTues = nbTues;
	}
	
	public int getArgent() {
		return argent;
	}
	
	public void setArgent(int argent) {
		this.argent = argent;
	}
	
	public String getNomGang() {
		return nomGang;
	}
	
	public void setNomGang(String nomGang) {
		this.nomGang = nomGang;
	}
	
	public void afficheInfosJoueur(){
		
	}
    
}
