package fr.STB1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.NONE)
@Entity
//@Table(name="membre")

public class Membre {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	//@Column(name="IdM")
	private int IdMembre;
	
	//@Column
	@XmlElement(name="gender")
    private Boolean Gender;
	
	//@Column(length=50)
	@XmlElement(name="nom")
	private String Nom;
	
	//@Column(length=50)
	@XmlElement(name="prenom")
    private String Prenom;
     
	
    public Membre(String cnom, String cprenom, boolean cgenre)
    {
    	this.Nom = cnom;
    	this.Prenom = cprenom;
    	this.Gender = cgenre; 
    	
    }
    public Membre(){}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public Boolean getGender() {
		return Gender;
	}
	public void setGender(Boolean gender) {
		Gender = gender;
	}
    
}
