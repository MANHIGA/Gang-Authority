package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Bannir")
public class Bannir implements Serializable{
	
	@Id
	@Column(name="Bannir_idAdmin")
    private Integer idAdmin;
	
	@Id
	@ManyToOne
	@JoinColumn(name="Bannir_idCompte")
    private Joueur joueurBanni;
	
	@Column(name="dureeBannissement")
    private Integer dureeBannissement;
	
	@Column(name="dateBannissement")
    private Date dateBannissement;	
	
	public Bannir(Joueur joueur, Integer idAdmin, Integer dureeBannissement, Date dateBannissement) {
		super();
		this.joueurBanni = joueur;
		this.idAdmin = idAdmin;
		this.dureeBannissement = dureeBannissement;
		this.dateBannissement = dateBannissement;
	}
	
	public Bannir(){}
	
	public Joueur getJoueurBanni() {
		return joueurBanni;
	}

	public void setJoueurBanni(Joueur joueurBanni) {
		this.joueurBanni = joueurBanni;
	}
	
	public Integer getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}

	public Integer getDureeBannissement() {
		return dureeBannissement;
	}

	public void setDureeBannissement(Integer dureeBannissement) {
		this.dureeBannissement = dureeBannissement;
	}

	public Date getDateBannissement() {
		return dateBannissement;
	}

	public void setDateBannissement(Date dateBannissement) {
		this.dateBannissement = dateBannissement;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o == null){
			return false;
		}	
		
		if(!(o instanceof Bannir)){
			return false;
		}
		
		Bannir b = (Bannir) o ;
		
		if(joueurBanni.getIdCompte() == b.getJoueurBanni().getIdCompte() && this.getIdAdmin() == b.getIdAdmin() && this.getDateBannissement() == b.getDateBannissement()){
			return true;
		}
		
		if(this == b){
			return true;
		}		
			
		return false;
	}
	
	@Override
	public int hashCode(){
		return joueurBanni.hashCode();
	}
	
}
