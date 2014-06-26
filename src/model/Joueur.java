package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
	
	@Column(name="joueurConnecte")
    private Boolean joueurConnecte;
	
	@Column(name="salt")
	private String salt;
    
	@Column(name="is_active")
	private Boolean is_active;
	
	@OneToMany(mappedBy="joueur",fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <Construire> mesBatiments = new ArrayList<Construire>();
	
	@OneToMany(mappedBy="joueur")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <Entrainer> mesSbires = new ArrayList<Entrainer>();;
	
	public Joueur(){}
	
	public Joueur(String pseudo, String email, String mdp, String nomGang) {
		this.pseudo = pseudo;
		this.email = email;
		this.mdp = mdp;
		this.pointAutorite = new Integer(0);
		this.nbMorts = new Integer(0);
		this.nbTues = new Integer(0);
		this.argent = new Integer(56);
		this.nomGang = nomGang;
		this.joueurConnecte = false;
		this.salt = "";
		this.is_active = false;
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
		this.pointAutorite += pointAutorite;
	}

	public Integer getNbMorts() {
		return nbMorts;
	}

	public void setNbMorts(Integer nbMorts) {
		this.nbMorts += nbMorts;
	}

	public Integer getNbTues() {
		return nbTues;
	}

	public void setNbTues(Integer nbTues) {
		this.nbTues += nbTues;
	}

	public Integer getArgent() {
		return argent;
	}

	public void setArgent(Integer argent) {
		
		Session s = AppFactory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
			this.argent += argent;
		s.update(this);	
		tx.commit();
		s.close();	
	}

	public String getNomGang() {
		return nomGang;
	}

	public void setNomGang(String nomGang) {
		this.nomGang = nomGang;
	}
	
	public Boolean getJoueurConnecte() {
		return joueurConnecte;
	}

	public void setJoueurConnecte(Boolean joueurConnecte) {
		
		Session s = AppFactory.getSessionFactory().openSession();
		Transaction tx = s.beginTransaction();
			this.joueurConnecte = joueurConnecte;
		s.update(this);
		tx.commit();
		s.close();
	}
	
	public List<Construire> getMesBatiments(){		
		return mesBatiments;
	}
	
	public List<Entrainer> getMesSbires(){
		return mesSbires;
	}
	
	public static Joueur getJoueurByPseudoMdp(String pseudo, String mdp){
		
		Session session = AppFactory.getSessionFactory().openSession();
	
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
		Transaction tx = session.beginTransaction();
		
			Construire c = new Construire(this,b,1,10);
			session.save(c);
		
		tx.commit();
		session.close();
		
		this.setArgent(new Integer(-10000));
		mesBatiments.add(c);
	}
	
	public void ameliorerBatiment(Construire c){
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
			c.setNiveau(c.getNiveau() + 1);
			c.setPopulationMax(c.getPopulationMax() + 10);
			session.update(c);
		
		tx.commit();
		session.close();
		
		int argentDepense = c.getNiveau() * 10000 * -2;
		this.setArgent(new Integer(argentDepense));		
	}
	
	public Entrainer getTypeSbireEntrainer(TypeSbire s){
		
		for(int i = 0; i < mesSbires.size(); i++){
			if(mesSbires.get(i).getTypeSbire().getLibelleTypeSbire() == s.getLibelleTypeSbire()){
				return mesSbires.get(i);
			}
		}
		
		return null;
	}
    
	public void recruterTypeSbire(TypeSbire s){
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		boolean sbireTrouve = false;
		
		for(int i = 0; i < this.getMesSbires().size(); i++){
			
			if(this.getMesSbires().get(i).getTypeSbire().getLibelleTypeSbire() == s.getLibelleTypeSbire()){
				this.getMesSbires().get(i).setNbSbire(1);
				session.update(this.getMesSbires().get(i));
				this.setArgent(-100);
				sbireTrouve = true;
			}
		}
		
		if(!sbireTrouve){
			Entrainer e = new Entrainer(this,s);
			mesSbires.add(e);
			session.save(e);
			this.setArgent(-100);
		}
		
		tx.commit();
		session.close();
	}
	
	public void ameliorerTypeSbire(Entrainer e){
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		e.setPointAttaque(100);
		e.setPointDefense(100);
		session.update(e);
		
		tx.commit();
		session.close();
	}
	
	public void recompenserJoueur(int recompensePointAutorite, int recompenseArgent){
		this.setPointAutorite(recompensePointAutorite);
		this.setArgent(recompenseArgent);
	}
	
	public boolean verifierJoueurArgent(int argentDepense){
		
		if(this.argent < argentDepense){
			return false;
		}else{
			return true;
		}
	}
	
	public void signalerJoueur(Joueur j, String justification){
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Signalement s = new Signalement(this,j,justification);
		session.save(s);
		
		tx.commit();
		session.close();
	}
	
	public List<Mission> getMissionsDisponibles(){
				
		Session s = AppFactory.getSessionFactory().openSession();
		Query q = s.createQuery("from Realiser where Realiser_idCompte = " + this.getIdCompte() + " order by dateRealisation");		
		List<Realiser> mesMissionsRealisees = (List<Realiser>)q.list();

		List<Mission> missionsDisponibles = Mission.getMissions();
		boolean missionTrouvee = false;
		int i = 0;
		
		for(Realiser r : mesMissionsRealisees){
			
			Date dateMissionDisponible = r.getDateRealisation();
			
			if(dateMissionDisponible.before(new Date())){
				
				while(!missionTrouvee && i < missionsDisponibles.size()){
					if(missionsDisponibles.get(i).getIdMission().equals(r.getMission().getIdMission())){
						missionsDisponibles.remove(i);
						missionTrouvee = true;
					}
					i++;
				}

			}		
		}
		
		s.close();
		
		if(missionsDisponibles.isEmpty()){
			return null;
		}else{
			return missionsDisponibles;
		}
	}
	
	public void realiserMission(Mission m, int nbSbiresEnvoyes){
		
		boolean missionTrouvee = false;
		int i = 0;	
		List<Mission> missionsDisponibles = this.getMissionsDisponibles();
		
		while(!missionTrouvee && i < missionsDisponibles.size()){
			
			if(m.getIdMission().equals(missionsDisponibles.get(i).getIdMission())){
				Session session = AppFactory.getSessionFactory().openSession();
				Transaction tx = session.beginTransaction();
				
				Realiser r = new Realiser(this,missionsDisponibles.get(i),nbSbiresEnvoyes);
				session.save(r);
				
				tx.commit();
				session.close();
				
				missionTrouvee = true;
			}
			i++;
		}	
	}
	
	public static List<Joueur> getJoueursConnectes(){
		
		Session s = AppFactory.getSessionFactory().openSession();
		Query q = s.createQuery("from Joueur where joueurConnecte = 1");	
		List<Joueur> joueursConnectes = (List<Joueur>)q.list();
		s.close();
		
		return joueursConnectes;
	}
	
	public static Joueur getJoueurByPseudo(String pseudo){
		
		Session s = AppFactory.getSessionFactory().openSession();
		Query q = s.createQuery("from Joueur where pseudo = '" + pseudo + "'");
		
		if(q.list().size() == 0){
			return null;
		}else{
			Joueur j = (Joueur)q.list().get(0);
			return j;
		}
	}
	
	public void combattreJoueur(Joueur defenseur, int nbSbiresEnvoyes){
		
		Session session = AppFactory.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
			Combattre c = new Combattre(this,defenseur, new Integer(nbSbiresEnvoyes));
			session.save(c);
		
		tx.commit();
		session.close();
	}
}
