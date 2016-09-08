import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.EntityManagerConnectionService;
import fr.STB1.model.Client;
import fr.STB1.model.Equipe;
import fr.STB1.model.ExigenceFonctionnelle;
import fr.STB1.model.Fonctionnalite;
import fr.STB1.model.Membre;
import fr.STB1.model.Stb;
import fr.STB1.model.StbList;
import fr.STB1.model.StbResume;
import services.ServiceStbImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		ExigenceFonctionnelle c = new ExigenceFonctionnelle("Premiere exigence", "pour le premier", 2);
		ExigenceFonctionnelle c1 = new ExigenceFonctionnelle("Deuxième exigence", "pour le deuxième", 3);
		List<ExigenceFonctionnelle> l = new ArrayList<ExigenceFonctionnelle>();
		l.add(c);
		l.add(c1);
		
		ExigenceFonctionnelle c3 = new ExigenceFonctionnelle("Premiere exigence", "pour le premier", 2);
		ExigenceFonctionnelle c4 = new ExigenceFonctionnelle("Deuxième exigence", "pour le deuxième", 3);
		List<ExigenceFonctionnelle> l2 = new ArrayList<ExigenceFonctionnelle>();
		l2.add(c4);
		l2.add(c3);
		Fonctionnalite f = new Fonctionnalite("ma fonctionnalite", 3);
		Fonctionnalite f1 = new Fonctionnalite("ma 2 fonctionnalite",4);
		f.setEf(l);
		f1.setEf(l2);
		List<Fonctionnalite> listeFonctionnalites = new ArrayList<Fonctionnalite>();
		listeFonctionnalites.add(f);
		listeFonctionnalites.add(f1);

		Equipe equipes = new Equipe();
		Membre a = new Membre("Yoan", "ziegler", false);
		Membre a11 = new Membre("Damien", "henry", false);
		//Membre a111 = new Membre("Omar", "qette", false);
		List<Membre> membres = new ArrayList<Membre>();
		membres.add(a);
		membres.add(a11);
		equipes.setMembres(membres);
		
		Client b = new Client("ddd", "dddd", "76130");

		String txtDate = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(new Date());
		Stb s = new Stb("Agora", "5", txtDate, "conception de jeux");
		s.setClient(b);
		s.setEquipe(equipes);
		s.setFonctionnalite(listeFonctionnalites);
		s.setComment("nouveau format de commentaire");
		
		ServiceStbImpl service = new ServiceStbImpl();
		//service.AddStb(s);
		
		// Deuxième STB

		ExigenceFonctionnelle c2 = new ExigenceFonctionnelle("stb2 Premiere exigence", "pour le premier", 5);
		ExigenceFonctionnelle c22 = new ExigenceFonctionnelle("stb2 Deuxième exigence", "pour le deuxième", 6);
		List<ExigenceFonctionnelle> l5 = new ArrayList<ExigenceFonctionnelle>();
		l5.add(c2);
		l5.add(c22);

		ExigenceFonctionnelle c7 = new ExigenceFonctionnelle("stb2 Premiere exigence", "pour le premier", 5);
		ExigenceFonctionnelle c77 = new ExigenceFonctionnelle("stb2 Deuxième exigence", "pour le deuxième", 6);
		List<ExigenceFonctionnelle> l6 = new ArrayList<ExigenceFonctionnelle>();
		l6.add(c7);
		l6.add(c77);
		Fonctionnalite f2 = new Fonctionnalite("stb2 ma fonctionnalite", 3);
		Fonctionnalite f22 = new Fonctionnalite("stb2 ma 2 fonctionnalite",4);
		f2.setEf(l5);
		f22.setEf(l6);
		List<Fonctionnalite> listeFonctionnalites2 = new ArrayList<Fonctionnalite>();
		listeFonctionnalites2.add(f2);
		listeFonctionnalites2.add(f22);

		Equipe equipes2 = new Equipe();
		Membre a2 = new Membre("Yoan", "ziegler", false);
		Membre a22 = new Membre("Damien", "henry", false);
		//Membre a111 = new Membre("Omar", "qette", false);
		List<Membre> membres2 = new ArrayList<Membre>();
		membres2.add(a2);
		membres2.add(a22);
		equipes2.setMembres(membres2);
		
		Client b2 = new Client("ddd", "dddd", "76130");

		String txtDate2 = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(new Date());
		Stb s2 = new Stb("Amical Gil", "1", txtDate2, "Plateforme pour les étudiants du master gil");
		s2.setClient(b2);
		s2.setEquipe(equipes2);
		s2.setFonctionnalite(listeFonctionnalites2);
		s2.setComment("Projet Utilitaire");

		List<Stb> ls = service.getAllStb();
		System.out.println(service.CountStb());

}}
