import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.validation.Validator;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.STB1.model.Client;
import fr.STB1.model.Equipe;
import fr.STB1.model.ExigenceFonctionnelle;
import fr.STB1.model.Fonctionnalite;
import fr.STB1.model.Membre;
import fr.STB1.model.Stb;
import fr.STB1.model.StbList;

public class Validate {

	public Validate() {
	}

	public static void main(String[] args) throws JAXBException, SAXException, IOException {

		StbList As = new StbList();
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
		

		As.getList().add(s);
		JAXBContext jc = JAXBContext.newInstance(StbList.class);
		JAXBSource source = new JAXBSource(jc, As);

		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File(Stb.class.getResource("stb.xsd").getPath()));

		Validator validator = schema.newValidator();
		// validator.setErrorHandler(new MyErrorHandler());
		validator.validate(source);
		// System.err.println("hhhhh");
	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {

		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException | SAXException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean ValidationWithObject(Stb stb) {
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		String path = "src/main/java/stb.xsd";
		Schema schema = null;
		try {
			schema = schemaFactory.newSchema(new File(path));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JAXBContext p = null;
		try {
			p = JAXBContext.newInstance(Stb.class);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Marshaller marshaller = null;
		try {
			marshaller = p.createMarshaller();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		marshaller.setSchema(schema);
		try {
			marshaller.marshal(stb, new DefaultHandler());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
