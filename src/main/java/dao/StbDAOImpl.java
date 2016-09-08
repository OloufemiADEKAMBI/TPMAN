package dao;

import fr.STB1.model.StbList;
import fr.STB1.model.StbResume;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.ejb.internal.EntityManagerFactoryRegistry;
import org.hibernate.sql.ordering.antlr.Factory;
import org.springframework.transaction.annotation.Transactional;

import fr.STB1.model.ListResume;
import fr.STB1.model.Stb;

public class StbDAOImpl implements IStbDAO {
	
	//private StbList Stbdao = new StbList();
	
	@PersistenceContext
	
	@Override
	public void AddStb(Stb stb) {
		
	//EntityManagerConnectionService.getInstance().getTransaction().rollback();
		EntityManagerConnectionService.getInstance().getTransaction().begin();
		EntityManagerConnectionService.getInstance().persist(stb);
		EntityManagerConnectionService.getInstance().getTransaction().commit();
	}

	@Override
	public void DeleteStb(int id) {
		// TODO Auto-generated method stub
//		Session s = HibernateUtil.getSessionFactory().openSession();
//		Stb stb = (Stb) s.load(Stb.class, id);
//		s.delete(stb);
	}

	@Override
	public List<Stb> getAllStb() {
		
//		EntityManagerConnectionService.getInstance().getTransaction().begin();
//		Query s = EntityManagerConnectionService.getInstance().createQuery("select s from Stb s");
//		EntityManagerConnectionService.getInstance().getTransaction().commit();
		
		List<Stb> s= EntityManagerConnectionService.getInstance().createQuery("from Stb").getResultList();
		return s;
		
		
	}

	@Override
	public Stb getStbById(int id) {
		EntityManagerConnectionService.getInstance().getTransaction().begin();
		Stb s = EntityManagerConnectionService.getInstance().find(Stb.class,id);
		EntityManagerConnectionService.getInstance().getTransaction().commit();
		return s;
	}

	@Override
	public void AddStbResume(StbResume stb) {

		EntityManagerConnectionService.getInstance().getTransaction().begin();
	EntityManagerConnectionService.getInstance().persist(stb);
	EntityManagerConnectionService.getInstance().getTransaction().commit();

	}

	@Override
	public int CountStb() {
		List<Stb> s= EntityManagerConnectionService.getInstance().createQuery("from Stb").getResultList();
		int i=0;
			for(Stb stb : s)
			i++;
		return i;
	}

	@Override
	public ListResume AllResume() {
		List<Stb> s= EntityManagerConnectionService.getInstance().createQuery("from Stb").getResultList();
		ListResume lr = new ListResume();
		for(Stb ls: s)
		{
			StbResume sr = new StbResume();
			sr.setId(ls.getId());
			sr.setTitreProjet(ls.getTitreProjet());
			sr.setVersion(ls.getVersion());
			sr.setDescription(ls.getDescription());
			sr.setDate(ls.getDate());
			lr.getStb().add(sr);
		}
		
		return lr;
	}

			
}
