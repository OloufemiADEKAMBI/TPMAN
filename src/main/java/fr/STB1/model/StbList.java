package fr.STB1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dao.IStbDAO;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name="Stbs")
public class StbList implements Serializable {

	@XmlElement(name="Stb")
	private List<Stb> Stbs;

	public List<Stb> getStbs() {
		return Stbs;
	}
	public void setStbs(List<Stb> stbs) {
		Stbs = stbs;
	}
	public StbList(){
		Stbs = new ArrayList<>();
	}
	public List<Stb> getList() {
		return Stbs;
	}

	public void setList(List<Stb> stb) {
		this.Stbs = stb;
	}
	
	public Stb getById(int id)
	{
		for (int i = 0; i < Stbs.size(); i++) {
			if(Stbs.get(i).getId() == id)
				return Stbs.get(i);
		}
		return null;
	}
}
