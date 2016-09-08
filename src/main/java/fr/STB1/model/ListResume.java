package fr.STB1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Stbs")
public class ListResume implements Serializable{

	@XmlElement(name="Stb")
	private List<StbResume> Stb = new ArrayList<>();

	public List<StbResume> getStb() {
		return Stb;
	}

	public void setStb(List<StbResume> stb) {
		Stb = stb;
	}

}
