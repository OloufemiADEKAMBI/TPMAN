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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@Entity
//@Table(name="equipe")
public class Equipe implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="IdE")
	private int IdEquipe;
	
	@OneToMany(cascade = {CascadeType.PERSIST})
	@XmlElement(name="membre")
	private List<Membre> membre;
    
    public List<Membre> getMembres() {
		return membre;
	}



	public void setMembres(List<Membre> membres) {
		this.membre = membres;
	}

	public Equipe() {}
    
}
