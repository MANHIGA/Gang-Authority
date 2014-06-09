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
	private int idMission;
	
	@Column(name="dureeMission")
	private int dureeMission;
	
	@Column(name="recompenseArgent")
	private int recompenseArgent;
	
	@Column(name="difficulte")
	private String difficulte; //String ou int, à déterminer
	
	@Column(name="recompensePointsAutorites")
	private int recompensePointsAutorites;
	
	@Column(name="tempsApparitionBase")
	private int tempsApparitionBase;
	
	@Column(name="nbMiniSbiresRequis")
	private int nbMiniSbiresRequis;

	public int getIdMission() {
		return idMission;
	}

	public void setIdMission(int idMission) {
		this.idMission = idMission;
	}

	public int getDureeMission() {
		return dureeMission;
	}

	public void setDureeMission(int dureeMission) {
		this.dureeMission = dureeMission;
	}

	public int getRecompenseArgent() {
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

	public int getRecompensePointsAutorites() {
		return recompensePointsAutorites;
	}

	public void setRecompensePointsAutorites(int recompensePointsAutorites) {
		this.recompensePointsAutorites = recompensePointsAutorites;
	}

	public int getTempsApparitionBase() {
		return tempsApparitionBase;
	}

	public void setTempsApparitionBase(int tempsApparitionBase) {
		this.tempsApparitionBase = tempsApparitionBase;
	}

	public int getNbMiniSbiresRequis() {
		return nbMiniSbiresRequis;
	}

	public void setNbMiniSbiresRequis(int nbMiniSbiresRequis) {
		this.nbMiniSbiresRequis = nbMiniSbiresRequis;
	}
}
