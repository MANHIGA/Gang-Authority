package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.Session;


@Entity
@Table(name="Mission")
public class Mission {
	
	@Id
	@GeneratedValue
	@Column(name="idMission")
	private Integer idMission;
	
	@Column(name="dureeMission")
	private Integer dureeMission;
	
	@Column(name="recompenseArgent")
	private Integer recompenseArgent;
	
	@Column(name="difficulte")
	private String difficulte; //String ou int, à déterminer
	
	@Column(name="recompensePointAutorite")
	private Integer recompensePointsAutorites;
	
	@Column(name="tempsReapparitionBase")
	private Integer tempsReapparitionBase;
	
	@Column(name="nbMiniSbiresRequis")
	private Integer nbMiniSbiresRequis;
	
	@OneToOne
	@JoinColumn(name = "Mission_idTypeSbire")
	private TypeSbire missionTypeSbire;
	
	public Mission(){}

	public Mission(Integer dureeMission, Integer recompenseArgent,
			String difficulte, Integer recompensePointsAutorites,
			Integer tempsApparitionBase, Integer nbMiniSbiresRequis) {
		super();
		this.dureeMission = dureeMission;
		this.recompenseArgent = recompenseArgent;
		this.difficulte = difficulte;
		this.recompensePointsAutorites = recompensePointsAutorites;
		this.tempsReapparitionBase = tempsApparitionBase;
		this.nbMiniSbiresRequis = nbMiniSbiresRequis;
	}

	public Integer getIdMission() {
		return idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public Integer getDureeMission() {
		return dureeMission;
	}

	public void setDureeMission(int dureeMission) {
		this.dureeMission = dureeMission;
	}

	public Integer getRecompenseArgent() {
		return recompenseArgent;
	}

	public void setRecompenseArgent(int recompenseArgent) {
		this.recompenseArgent = recompenseArgent;
	}

	public String getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(String difficulte) {
		this.difficulte = difficulte;
	}

	public Integer getRecompensePointsAutorites() {
		return recompensePointsAutorites;
	}

	public void setRecompensePointsAutorites(int recompensePointsAutorites) {
		this.recompensePointsAutorites = recompensePointsAutorites;
	}

	public Integer getTempsReapparitionBase() {
		return tempsReapparitionBase;
	}

	public void setTempsReapparitionBase(int tempsApparitionBase) {
		this.tempsReapparitionBase = tempsApparitionBase;
	}

	public Integer getNbMiniSbiresRequis() {
		return nbMiniSbiresRequis;
	}

	public void setNbMiniSbiresRequis(int nbMiniSbiresRequis) {
		this.nbMiniSbiresRequis = nbMiniSbiresRequis;
	}
	
	public TypeSbire getMissionTypeSbire() {
		return missionTypeSbire;
	}

	public void setMissionTypeSbire(TypeSbire missionTypeSbire) {
		this.missionTypeSbire = missionTypeSbire;
	}
	
	public static List<Mission> getMissions(){
		Session s = AppFactory.getSessionFactory().openSession();
		
		Query q = s.createQuery("from Mission");
		
		if(!(q.list().isEmpty())){
			List<Mission> m = (List<Mission>) q.list();
			s.close();
			return m;
		}else{
			s.close();
			return null;
		}
	}
}
