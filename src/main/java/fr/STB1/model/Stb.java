package fr.STB1.model;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.stream.events.Comment;

import org.hibernate.annotations.Cascade;



@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="mastb")
@Entity
public class Stb implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	@XmlElement(name="Id")
	private int id;  
	
	//@Column(length=50)
	@XmlElement(name="Titreduprojet")
	private String titreProjet;
	
	//@Column(length=50)
	@XmlElement(name="Version")
	private String version;
	
	//@Column(length=50)
	@XmlElement(name="date")
	private String date;
	
	//@Column(length=50)
	@XmlElement(name="Description")
	private String description;

	@XmlElement(name="Client")
	@OneToOne(cascade = {CascadeType.PERSIST})
	private Client client;
	
	@XmlElement(name="Equipe")
	@OneToOne(cascade = {CascadeType.PERSIST})
	private Equipe equipe;

	
	@XmlElement(name="Fonctionnalite")
	@OneToMany(cascade = {CascadeType.PERSIST})
	private List<Fonctionnalite> fonctionnalite ;

	//@Column(length=50)
	@XmlElement(name="Commentaire")
	private String comment;

	public Stb(String cTitreProjet, String cVersion, String cDate, String cDescription) {

		
		this.titreProjet = cTitreProjet;
		this.version = cVersion;
		this.date = cDate;
		this.description = cDescription;
	}



	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Stb(){}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}

	public Equipe getEquipe() {
		return equipe;
	}

	public void setEquipe(Equipe equipe) {
		this.equipe = equipe;
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



	public List<Fonctionnalite> getFonctionnalite() {
		return fonctionnalite;
	}



	public void setFonctionnalite(List<Fonctionnalite> fonctionnalite) {
		this.fonctionnalite = fonctionnalite;
	}	

}

