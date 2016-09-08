package services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.StbDAOImpl;
import fr.STB1.model.ListResume;
import fr.STB1.model.Stb;
import fr.STB1.model.StbList;
import fr.STB1.model.StbResume;

@Transactional
public class ServiceStbImpl implements IServicesStb {

	private StbDAOImpl s = new StbDAOImpl(); 
	@Override
	public void AddStb(Stb stb) {
		// TODO Auto-generated method stub
		s.AddStb(stb);
	}

	@Override
	public void DeleteStb(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Stb> getAllStb() {
		// TODO Auto-generated method stub
		
		return s.getAllStb();
	}

	@Override
	public Stb getStbById(int id) {
		return s.getStbById(id);
	}

	@Override
	public void AddStbResume(StbResume stb) {
		s.AddStbResume(stb);
	}

	@Override
	public int CountStb() {
		
		return s.CountStb();
	}

	@Override
	public ListResume AllResume() {
	
		return s.AllResume();	
	}

}
