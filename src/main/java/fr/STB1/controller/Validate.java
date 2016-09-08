//package fr.STB1.controller;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//import javax.xml.XMLConstants;
//import javax.xml.bind.JAXBContext;
//import javax.xml.bind.JAXBException;
//import javax.xml.bind.Marshaller;
//import javax.xml.bind.util.JAXBSource;
//import javax.xml.validation.Validator;
//import javax.xml.transform.stream.StreamSource;
//import javax.xml.validation.Schema;
//import javax.xml.validation.SchemaFactory;
//
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
//
//import fr.STB1.model.Client;
//import fr.STB1.model.Equipe;
//import fr.STB1.model.ExigenceFonctionnelle;
//import fr.STB1.model.Fonctionnalite;
//import fr.STB1.model.Membre;
//import fr.STB1.model.Stb;
//import fr.STB1.model.StbList;
//
//public class Validate {
//
//
//	public Validate(){}
//	public static void main(String[] args) throws JAXBException, SAXException, IOException {
//		/*if(validateXMLSchema("src/main/java/stb.xsd", "src/main/java/stb.xml"))
//			System.out.println("Xml valide par rapport au schéma");
//		if(!validateXMLSchema("src/main/java/stb.xsd", "src/main/java/stb.xml"))
//			System.out.println("Xml pas valide par rapport au schéma");*/
//			
//		StbList As = new StbList();
//		ExigenceFonctionnelle c = new ExigenceFonctionnelle("adek", "romaric", 2);
//		List<ExigenceFonctionnelle> l = new ArrayList<>();
//		l.add(c);
//
//		Fonctionnalite f = new Fonctionnalite("ma fonctionnalite", 3, l);
//		Fonctionnalite f1 = new Fonctionnalite("ma 2 fonctionnalite", 4, l);
//		List<Fonctionnalite> FF = new ArrayList<>();
//		
//		FF.add(f);
//		FF.add(f1);
//
//		Equipe equipes = new Equipe();
//		Membre a = new Membre("Yoan", "ziegler", false);
//		Membre a11 = new Membre("Damien", "henry", false);
//		Membre a111 = new Membre("Omar", "qette", false);
//		equipes.getMembres().add(a);
//		equipes.getMembres().add(a11);
//		equipes.getMembres().add(a111);
//		
//		Client b = new Client("ddd","dddd", "76130");
//
//		String txtDate=new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE).format(new Date());
//		Stb s = new Stb(1, "Agora", "5", txtDate, "conception de jeux");
//		s.setClient(b);
//		s.setEquipe(equipes);
//		s.setFonctionnalite(FF);
//		s.setComment("nouveau format de commentaire");
//
//		As.getList().add(s);
//        JAXBContext jc = JAXBContext.newInstance(StbList.class);
//        JAXBSource source = new JAXBSource(jc, As);
//
//        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
//        Schema schema = sf.newSchema(new File("src/main/java/stb.xsd")); 
//
//        Validator validator = schema.newValidator();
//       // validator.setErrorHandler(new MyErrorHandler());
//        validator.validate(source);
//
//	}
//
//	public static boolean validateXMLSchema(String xsdPath, String xmlPath){
//
//		try {
//			SchemaFactory factory = 
//					SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//			Schema schema = factory.newSchema(new File(xsdPath));
//			Validator validator = schema.newValidator();
//			validator.validate(new StreamSource(new File(xmlPath)));
//		} 
//		catch (IOException | SAXException e) {
//			System.out.println("Exception: "+e.getMessage());
//			return false;
//		}
//		return true;
//	}
//	public boolean ValidationWithObject(Stb stb)
//	{
//		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
//		String path = "src/main/java/stb.xsd";
//		Schema schema = null;
//		try {
//			schema = schemaFactory.newSchema(new File(path));
//		} catch (SAXException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//
//		JAXBContext p = null;
//		try {
//			p = JAXBContext.newInstance(Stb.class);
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Marshaller marshaller = null;
//		try {
//			marshaller = p.createMarshaller();
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//		}
//		marshaller.setSchema(schema);
//		try {
//			marshaller.marshal(stb, new DefaultHandler());
//		} catch (JAXBException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
//	
//}
