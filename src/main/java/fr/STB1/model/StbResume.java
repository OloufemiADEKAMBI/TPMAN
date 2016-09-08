package fr.STB1.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Stb")

public class StbResume {

	
	@XmlElement(name="Id")
    private int id;  
	
	@XmlElement(name="Titreduprojet")
    private String titreProjet;
	
	@XmlElement(name="Version")
    private String version;
	
	
	@XmlElement(name="date")
    private String date;
	
	@XmlElement(name="Description")
   private String description;
	
	public StbResume( int cid, String cTitreProjet, String cVersion, String cDate, String cDescription) {
        
    	super();
    	this.id = cid;
        this.titreProjet = cTitreProjet;
        this.version = cVersion;
        this.date = cDate;
        this.description = cDescription;
        
    }
	public StbResume(){}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitreProjet() {
		return titreProjet;
	}
	public void setTitreProjet(String titreProjet) {
		this.titreProjet = titreProjet;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
