package fr.STB1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.ManyToAny;

@XmlAccessorType(XmlAccessType.NONE)
@Entity
public class Fonctionnalite implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int IdFonctionnalite;
	
	
	@XmlElement(name="Description")
    private String DescriptionF;
    

    @XmlAttribute
    private int Priorite;
   
	@OneToMany(cascade = {CascadeType.PERSIST})
	@XmlElement(name="exigenceF")
    private List<ExigenceFonctionnelle> Ef;

    public Fonctionnalite(String cdesc, int priorite)
    {	
    	this.DescriptionF = cdesc;
    	this.Priorite = priorite;
    	
    }
    
    public Fonctionnalite() {}

	public String getDescription() {
		return DescriptionF;
	}

	public void setDescription(String description) {
		this.DescriptionF = description;
	}

	public int getPriorite() {
		return Priorite;
	}

	public void setPriorite(int priorite) {
		this.Priorite = priorite;
	}


	public int getIdFonctionnalite() {
		return IdFonctionnalite;
	}

	public void setIdFonctionnalite(int idFonctionnalite) {
		IdFonctionnalite = idFonctionnalite;
	}

	
	public String getDescriptionF() {
		return DescriptionF;
	}

	public void setDescriptionF(String descriptionF) {
		DescriptionF = descriptionF;
	}

	public List<ExigenceFonctionnelle> getEf() {
		return Ef;
	}

	public void setEf(List<ExigenceFonctionnelle> ef) {
		Ef = ef;
	}
    
    
}
