package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


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
	
	@Column(name="recompensePointsAutorites")
	private Integer recompensePointsAutorites;
	
	@Column(name="tempsApparitionBase")
	private Integer tempsApparitionBase;
	
	@Column(name="nbMiniSbiresRequis")
	private Integer nbMiniSbiresRequis;
	
	public Mission(){}

	public Mission(Integer dureeMission, Integer recompenseArgent,
			String difficulte, Integer recompensePointsAutorites,
			Integer tempsApparitionBase, Integer nbMiniSbiresRequis) {
		super();
		this.dureeMission = dureeMission;
		this.recompenseArgent = recompenseArgent;
		this.difficulte = difficulte;
		this.recompensePointsAutorites = recompensePointsAutorites;
		this.tempsApparitionBase = tempsApparitionBase;
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

	public Integer getTempsApparitionBase() {
		return tempsApparitionBase;
	}

	public void setTempsApparitionBase(int tempsApparitionBase) {
		this.tempsApparitionBase = tempsApparitionBase;
	}

	public Integer getNbMiniSbiresRequis() {
		return nbMiniSbiresRequis;
	}

	public void setNbMiniSbiresRequis(int nbMiniSbiresRequis) {
		this.nbMiniSbiresRequis = nbMiniSbiresRequis;
	}
}
