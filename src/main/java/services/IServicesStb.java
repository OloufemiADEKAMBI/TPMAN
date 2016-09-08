package services;

import java.util.List;

import fr.STB1.model.ListResume;
import fr.STB1.model.Stb;
import fr.STB1.model.StbList;
import fr.STB1.model.StbResume;

public interface IServicesStb {

	public void AddStb(Stb stb);
	public void DeleteStb(int id);
	public List<Stb> getAllStb();
	public Stb getStbById(int id); 
	public void AddStbResume(StbResume stb);
	public int CountStb();
	public ListResume AllResume();
}
