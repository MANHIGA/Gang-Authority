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
import org.hibernate.SessionFactory;

@Entity
@Table(name="TypeSbire")
public class TypeSbire {
	
	@Id
	@GeneratedValue
	@Column(name="idTypeSbire")
    private Integer idTypeSbire;
	
	@Column(name="libelleTypeSbire")
    private String libelleTypeSbire;
	
	@Column(name="cout")
    private Integer cout;
	
	@Column(name="tempsApparition")
    private Integer tempsApparition;
	
	@OneToOne
	@JoinColumn(name="TypeSbire_idTypeBatiment")
	private TypeBatiment typeBatiment;
	
	public TypeSbire(){}

	public TypeSbire(String libelleTypeSbire, Integer cout,
			Integer tempsApparition, TypeBatiment typeBatiment) {
		super();
		this.libelleTypeSbire = libelleTypeSbire;
		this.cout = cout;
		this.tempsApparition = tempsApparition;
		this.typeBatiment = typeBatiment;
	}

	public Integer getIdTypeSbire() {
		return idTypeSbire;
	}

	public void setIdTypeSbire(Integer idTypeSbire) {
		this.idTypeSbire = idTypeSbire;
	}

	public String getLibelleTypeSbire() {
		return libelleTypeSbire;
	}

	public void setLibelleTypeSbire(String libelleTypeSbire) {
		this.libelleTypeSbire = libelleTypeSbire;
	}

	public Integer getCout() {
		return cout;
	}

	public void setCout(Integer cout) {
		this.cout = cout;
	}

	public Integer getTempsApparition() {
		return tempsApparition;
	}

	public void setTempsApparition(Integer tempsApparition) {
		this.tempsApparition = tempsApparition;
	}

	public TypeBatiment getTypeBatiment() {
		return typeBatiment;
	}

	public void setTypeBatiment(TypeBatiment typeBatiment) {
		this.typeBatiment = typeBatiment;
	}
	
	public static List<TypeSbire> getTypesSbires(){
		
		Session s = AppFactory.getSessionFactory().openSession();
		
		Query q = s.createQuery("from TypeSbire");
		
		
		if(!q.list().isEmpty()){
			List<TypeSbire> ts = (List<TypeSbire>)q.list();
			s.close();
			return ts;
		}else{
			s.close();
			return null;
		}
		
	}
}