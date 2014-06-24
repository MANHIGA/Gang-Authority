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
    
	@OneToMany(mappedBy="joueur",fetch=FetchType.EAGER)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <Construire> mesBatiments;
	
	@OneToMany(mappedBy="joueur")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List <Entrainer> mesSbires;
	
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
		Session session = AppFactory.getSessionFactory().openSession();
		this.pointAutorite += pointAutorite;
		session.update(this);
		session.close();
	}

	public Integer getNbMorts() {
		return nbMorts;
	}

	public void setNbMorts(Integer nbMorts) {
		Session session = AppFactory.getSessionFactory().openSession();
		this.nbMorts += nbMorts;
		session.update(this);
		session.close();
	}

	public Integer getNbTues() {
		return nbTues;
	}

	public void setNbTues(Integer nbTues) {
		Session session = AppFactory.getSessionFactory().openSession();
		this.nbTues += nbTues;
		session.update(this);
		session.close();
	}

	public Integer getArgent() {
		return argent;
	}

	public void setArgent(Integer argent) {
		Session session = AppFactory.getSessionFactory().openSession();
		this.argent += argent;
		session.update(this);
		session.close();
	}

	public String getNomGang() {
		return nomGang;
	}

	public void setNomGang(String nomGang) {
		this.nomGang = nomGang;
	}
	
	public List<Construire> getMesBatiments(){		
		return mesBatiments;
	}
	
	public List<Entrainer> getMesSbires(){
		return mesSbires;
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
	
	public void ameliorerBatiment(Construire c){
		
		Session session = AppFactory.getSessionFactory().openSession();
	
		c.setNiveau(c.getNiveau() + 1);
		c.setPopulationMax(c.getPopulationMax() + 10);
		session.update(c);
			
		session.close();
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
		
		boolean sbireTrouve = false;
		
		for(int i = 0; i < this.getMesSbires().size(); i++){
			
			if(this.getMesSbires().get(i).getTypeSbire().getLibelleTypeSbire() == s.getLibelleTypeSbire()){
				this.getMesSbires().get(i).setNbSbire(1);
				session.update(this.getMesSbires().get(i));
				sbireTrouve = true;
			}
		}
		
		if(!sbireTrouve){
			Entrainer e = new Entrainer(this,s);
			mesSbires.add(e);
			session.save(e);
		}
		
		session.close();
	}
	
	public void ameliorerTypeSbire(Entrainer e){
		
		Session session = AppFactory.getSessionFactory().openSession();
	
		e.setPointAttaque(100);
		e.setPointDefense(100);
		session.update(e);
			
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
		Signalement s = new Signalement(this,j,justification);
		session.save(s);
		session.close();
	}
	
	public List<Mission> getMissionsDisponibles(){
				
		Session s = AppFactory.getSessionFactory().openSession();
		
		Query q = s.createQuery("from Realiser where Realiser_idCompte = " + this.getIdCompte() + " order by dateRealisation");		
		List<Realiser> mesMissionsRealisees = (List<Realiser>)q.list();
		
		List<Mission> missionsDisponibles = Mission.getMissions();
		
		for(Realiser r : mesMissionsRealisees){
			
			Date dateMissionDisponible = r.getDateRealisation();
			
			if(dateMissionDisponible.before(new Date())){
				missionsDisponibles.remove(r.getMission());
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
		
		Session s = AppFactory.getSessionFactory().openSession();
		boolean missionTrouvee = false;
		int i = 0;
		
		List<Mission> missionsDisponibles = this.getMissionsDisponibles();
		
		while(!missionTrouvee && i < missionsDisponibles.size()){
			
			if(m.getIdMission().equals(missionsDisponibles.get(i).getIdMission())){
				Realiser r = new Realiser(this,missionsDisponibles.get(i),nbSbiresEnvoyes);
				s.save(r);
				missionTrouvee = true;
			}
			i++;
		}
		s.close();
	}
	
	public static List<Joueur> getJoueursConnectes(){
		
		return null;
	}
	
}
