package fr.STB1.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "Client")
@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="IdC")
	private int IdClient;
	
	//@Column(length=50)
	@XmlElement(name="entite")
	private String Entite;
	
	//@Column(length=50)
	@XmlElement(name="contact")
	private String Contact;
	
	//@Column(length=50)
	@XmlElement(name="Codepostal")
	private String Codepostale;

	public Client(String centite, String ccontact, String ccp) {
		this.Entite = centite;
		this.Contact = ccontact;
		this.Codepostale = ccp;
	}

	public Client() {
	}

	public String getEntite() {
		return this.Entite;
	}

	public void setEntite(String entite) {
		this.Entite = entite;
	}

	public String getContact() {
		return this.Contact;
	}

	public void setContact(String contact) {
		this.Contact = contact;
	}

	public String getCodepostale() {
		return this.Codepostale;
	}

	public void setCodepostale(String codepostale) {
		this.Codepostale = codepostale;
	}

}
