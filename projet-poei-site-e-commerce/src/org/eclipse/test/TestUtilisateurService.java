package org.eclipse.test;

import java.util.ArrayList;
import org.eclipse.model.*;
import org.eclipse.service.*;

public class TestUtilisateurService {

	public static void main(String[] args) {
		
		ArrayList<Utilisateur> utilisateursInitiaux = new ArrayList<Utilisateur>();
		UtilisateurService utilisateurService = new UtilisateurService(utilisateursInitiaux);

		System.out.println(utilisateurService);

		Adresse adresse1 = new Adresse("8", "Avenue Jacques Chirac", "Aix La Chapelle", "84512", "France", "");
		Adresse adresse2 = new Adresse("30", "Rue des elfes", "Lannion", "64021", "France", "");
		Adresse adresse3 = new Adresse("14", "Rue Amiral Ronarc'h", "Quimperlé", "74005", "France", "");
		Adresse adresse4 = new Adresse("1870", "Jack the Ripper street", "London", "0105", "England", "");
		Adresse adresse5 = new Adresse("140", "Rue des cordonniers", "Lyon", "31003", "France", "");
		ArrayList<Adresse> adresses1 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses2 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses3 = new ArrayList<Adresse>();
		ArrayList<Adresse> adresses4 = new ArrayList<Adresse>();
		adresses1.add(adresse1);
		adresses2.add(adresse2);
		adresses3.add(adresse3);
		adresses3.add(adresse4);
		adresses4.add(adresse5);
		Utilisateur utilisateur1 = new Utilisateur("00000001", "Durouet", "Etienne", "etienneD@yahoo.fr", "0643246167", "DurouetE",
				"AucuneIdée", adresses1);
		Utilisateur utilisateur2 = new Utilisateur("00000002", "Lescard", "Dominique", "dominique.lescard@gmail.com", "0643213265",
				"DominiqueLescard", "VivelaBretagne!", adresses2);
		Utilisateur utilisateur3 = new Utilisateur("00000003", "Desmoulins", "Francois", "francois.des@sf.fr", "0761621733",
				"FrancoisDD", "JaimelaBière", adresses3);
		Utilisateur utilisateur4 = new Utilisateur("00000004", "Bouchard", "Paul", "paul.bouchard@orange.fr", "0673413473",
				"Paul-Bouchard", "S3ri3us3m3nt", adresses4);

		if (!utilisateurService.save(utilisateur1))
			System.out.println("Echec de l'ajout : utilisateur identique déjà présent");
		System.out.println(utilisateurService);

		if (!utilisateurService.save(utilisateur2))
			System.out.println("Echec de l'ajout : utilisateur identique déjà présent");
		System.out.println(utilisateurService);

		if (!utilisateurService.save(utilisateur3))
			System.out.println("Echec de l'ajout : utilisateur identique déjà présent");
		System.out.println(utilisateurService);

		if (!utilisateurService.save(utilisateur2))
			System.out.println("Echec de l'ajout : utilisateur identique déjà présent");
		System.out.println(utilisateurService);

		if (!utilisateurService.remove(utilisateur1))
			System.out.println("Echec de la suppression : cet utilisateur n'est pas présent dans la liste");
		System.out.println(utilisateurService);

		if (!utilisateurService.remove(utilisateur4))
			System.out.println("Echec de la suppression : cet utilisateur n'est pas présent dans la liste");
		System.out.println(utilisateurService);

		utilisateur3.setPrenom("Xavier");
		utilisateur3.setAdresseMail("xavier.des@sfr.fr");
		if (!utilisateurService.update(utilisateur3))
			System.out.println("Echec de la mise à jour : cet utilisateur n'est pas présent dans la liste");
		System.out.println(utilisateurService);

		utilisateur4.setMotDePasse("FaceJohnCena");
		if (!utilisateurService.update(utilisateur4))
			System.out.println("Echec de la mise à jour : cet utilisateur n'est pas présent dans la liste");
		System.out.println(utilisateurService);

		ArrayList<Utilisateur> utilisateursAInstantT = utilisateurService.findAll();
		System.out.println(utilisateursAInstantT);

		System.out.println("L'utilisateur ayant pour id : 00000002 est : " + utilisateurService.findById("00000002"));
		System.out.println("L'utilisateur ayant pour id : 00000004 est : " + utilisateurService.findById("00000004"));

		utilisateurService.findById("00000002").setIdentifiantConnexion("DominiqueLeBreton");
		System.out.println(utilisateurService);
		
		System.out.println(utilisateurService.findByLoginAndPassword("FrancoisDD", "JaimelaBière"));
		System.out.println(utilisateurService.findByLoginAndPassword("FrancoisDD", "JaimeLaBière"));
	}

}
