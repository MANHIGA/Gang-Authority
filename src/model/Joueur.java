/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.*;
import org.hibernate.Query;

@Entity
@Table(name="joueur")
public class Joueur {
	
	@Id
	@GeneratedValue
	@Column(name="idCompte")
    private int idCompte;
	
	@Column(name="pseudo")
    private String pseudo;
	
	@Column(name="email")
    private String email;
	
	@Column(name="mdp")
    private String mdp;
	
	@Column(name="pointsAutorite")
    private int pointsAutorite;
	
	@Column(name="nbMorts")
    private int nbMorts;
	
	@Column(name="nbTues")
    private int nbTues;
	
	@Column(name="argent")
    private int argent;
	
	@Column(name="nomGang")
    private String nomGang;
    
	private List <Construire> mesBatiments;
	private List <Entrainer> mesSbires;
	
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
	
	public static boolean identifierJoueur(String pseudo, String mdp){
		
		SessionFactory sessionFactory = AppFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		Query query = session.createQuery("from joueur where pseudo = " + pseudo + " and mdp = " + mdp);
		List<Joueur> l = query.list();
		
		return l.isEmpty();
	}
    
}
