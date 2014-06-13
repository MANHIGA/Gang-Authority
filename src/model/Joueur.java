package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name="Joueur")
public class Joueur {
	
	@Id
	@GeneratedValue
	@Column(name="idCompte")
    private Integer idCompte;
	
	@Column(name="pseudo")
    private String pseudo;
	
	@Column(name="email")
    private String email;
	
	@Column(name="mdp")
    private String mdp;
	
	@Column(name="pointAutorite")
    private Integer pointAutorite;
	
	@Column(name="nbMorts")
    private Integer nbMorts;
	
	@Column(name="nbTues")
    private Integer nbTues;
	
	@Column(name="argent")
    private Integer argent;
	
	@Column(name="nomGang")
    private String nomGang;
    
	@OneToMany
	private List <Construire> mesBatiments;
	
	//private List <Entrainer> mesSbires;
	
	public Joueur(){}
	
	public Joueur(String pseudo, String email, String mdp,
			Integer pointAutorite, Integer nbMorts, Integer nbTues,
			Integer argent, String nomGang) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.mdp = mdp;
		this.pointAutorite = pointAutorite;
		this.nbMorts = nbMorts;
		this.nbTues = nbTues;
		this.argent = argent;
		this.nomGang = nomGang;
	
	}

	public Integer getIdCompte() {
		return idCompte;
	}

	public void setIdCompte(Integer idCompte) {
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

	public Integer getPointAutorite() {
		return pointAutorite;
	}

	public void setPointAutorite(Integer pointAutorite) {
		this.pointAutorite = pointAutorite;
	}

	public Integer getNbMorts() {
		return nbMorts;
	}

	public void setNbMorts(Integer nbMorts) {
		this.nbMorts = nbMorts;
	}

	public Integer getNbTues() {
		return nbTues;
	}

	public void setNbTues(Integer nbTues) {
		this.nbTues = nbTues;
	}

	public Integer getArgent() {
		return argent;
	}

	public void setArgent(Integer argent) {
		this.argent = argent;
	}

	public String getNomGang() {
		return nomGang;
	}

	public void setNomGang(String nomGang) {
		this.nomGang = nomGang;
	}
	
	public List<Construire> getMesBatiments(){
		
		if(mesBatiments.isEmpty()){
			
			SessionFactory sessionFactory = AppFactory.getSessionFactory();
			Session session = sessionFactory.openSession();
			
			Query q = session.createQuery("from Construire where Construire_idCompte = " + this.idCompte);
			
			if(!(q.list().isEmpty())){
				mesBatiments = (List<Construire>) q.list();
			}
			session.close();
		}
		
		return mesBatiments;
	}
	
	public static Joueur getJoueurByPseudoMdp(String pseudo, String mdp){
		
		SessionFactory sessionFactory = AppFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
	
		Query query = session.createQuery("from Joueur where pseudo = '" + pseudo + "' and mdp = '" + mdp + "'");
		
		if(query.list().isEmpty()){
			session.close();
			return null;
		}else {
			Joueur j = (Joueur)query.list().get(0);
			session.close();
			return j;
		}
			
	}
	
	public void creerBatiment(TypeBatiment b){
		
		Session session = AppFactory.getSessionFactory().openSession();
		
		Construire c = new Construire(this,b,1,10);
		session.save(c);
		
		mesBatiments.add(c);
		
		session.close();
	}
	
	public void ameliorerBatiment(TypeBatiment b){
		
		Session session = AppFactory.getSessionFactory().openSession();
		
		Query query = session.createQuery("from Construire where Construire_idCompte = " + idCompte + " and Construire_idTypeBatiment = " + b.getIdTypeBatiment());
		
		if(!(query.list().isEmpty())){
			Construire c = (Construire)query.list().get(0);
			System.out.println(c.getNiveau());
			c.setNiveau(c.getNiveau() + 1);
			c.setPopulationMax(c.getPopulationMax() + 10);
			session.update(c);
			
			session.close();
		}
	}
    
}
