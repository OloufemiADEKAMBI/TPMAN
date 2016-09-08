package fr.STB1.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fr.STB1.model.Client;
import fr.STB1.model.Equipe;
import fr.STB1.model.ExigenceFonctionnelle;
import fr.STB1.model.Fonctionnalite;
import fr.STB1.model.ListResume;
import fr.STB1.model.Membre;
import fr.STB1.model.Stb;
import fr.STB1.model.StbList;
import services.IServicesStb;
import services.ServiceStbImpl;

@RestController
public class HomeController {

	IServicesStb stbService;

	public HomeController() {
		stbService = new ServiceStbImpl();
	}

	@RequestMapping(value = "/All")
	public @ResponseBody StbList afficher_stb() {

		StbList ls = new StbList();
		ls.setList(stbService.getAllStb());
		return ls;

	}

	@RequestMapping(value = "/resume")
	public @ResponseBody ListResume afficher_Resumestb() {
		return stbService.AllResume();
		
	}

	@RequestMapping(value = "/resume/{id}")
	public @ResponseBody Stb afficher_ResumeParId(@PathVariable("id") int id) {

		ServiceStbImpl service = new ServiceStbImpl();
		Stb s = service.getStbById(id);
		return s;
	}

	@RequestMapping(value = "/Acceuil")
	public @ResponseBody String Acceuil() {
		System.out.println("Nombre de Stb :" + stbService.CountStb());

		/*
		 * Validate v = new Validate(); if (v.ValidationWithObject(s)) return
		 * "Toutes les STB présentes actuellement sont valides"; else return
		 * "problème de validation avec certaines Présentes";
		 */
		return "Nombre de Stb :" + stbService.CountStb();
	}
	
	@RequestMapping(value = "/Ajout", method=RequestMethod.POST)
	public void post() {
		ServiceStbImpl service = new ServiceStbImpl();
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
		

		service.AddStb(s);
		
		System.out.println("Stb ajouté"); 
	}
}
