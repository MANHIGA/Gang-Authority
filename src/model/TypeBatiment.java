package model;

import java.util.ArrayList;
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
@Table(name="TypeBatiment")
public class TypeBatiment {
	
	@Id
	@GeneratedValue
	@Column(name="idTypeBatiment")
    private Integer idTypeBatiment;
	
    
    @Column(name="libelleTypeBatiment")
    private String libelleTypeBatiment;
    
    @Column(name="tempsCreationBatiment")
    private Integer tempsCreationBatiment;
    
    @OneToOne
    @JoinColumn(name="TypeBatiment_idTypeSbire")
    private TypeSbire typeSbire;
    
    public TypeBatiment(){}
    
    public TypeBatiment(String libelleTypeBatiment, Integer tempsCreationBatiment){
    	super();
    	this.libelleTypeBatiment = libelleTypeBatiment;
    	this.tempsCreationBatiment = tempsCreationBatiment;
    }

	public TypeBatiment(String libelleTypeBatiment,Integer tempsCreationBatiment, TypeSbire typeSbire) {
		super();
		this.libelleTypeBatiment = libelleTypeBatiment;
		this.tempsCreationBatiment = tempsCreationBatiment;
		this.typeSbire = typeSbire;
	}

	public Integer getIdTypeBatiment() {
		return idTypeBatiment;
	}

	public String getLibelleTypeBatiment() {
		return libelleTypeBatiment;
	}

	public Integer getTempsCreationBatiment() {
		return tempsCreationBatiment;
	}

	public TypeSbire getTypeSbire() {
		return typeSbire;
	}
    
	public static List<TypeBatiment> getTypesBatiments(){
		
		SessionFactory sessionFactory = AppFactory.getSessionFactory();
		Session session = sessionFactory.openSession();
	
		Query query = session.createQuery("from TypeBatiment");
		
		if(!(query.list().isEmpty())){
			List <TypeBatiment> tb = (List<TypeBatiment>) query.list();
			session.close();
			return tb;
		}else{
			session.close();
			return null;
		}
		
	}
    
    
    
    
}
