package org.eclipse.service;

import java.util.ArrayList;

import org.eclipse.dao.ProduitDao;
import org.eclipse.model.Produit;

public class ProduitService {
	private ProduitDao produitDao = new ProduitDao();

	// Methode pour ajouter un produit dans la BdD
	public Produit save(Produit produit) throws Exception {
		if (produit.getIdVendeur() == 0) {
			throw new Exception("Erreur : idVendeur manquant !");
		}
		return produitDao.save(produit);
	}

	// Methode pour retirer un produit de la BdD
	public void remove(Produit produit) throws Exception {
		if (produitDao.findById(produit.getId()) == null) {
			throw new Exception("Le produit n'appartient pas a la liste");
		} 
		produitDao.remove(produit);
	}

	// Methode pour mettre a jour un produit dans la BdD
	public Produit update(Produit produit) throws Exception {
		if (produitDao.findById(produit.getId()) == null) {
			throw new Exception("Le produit n'appartient pas a la liste");
		} 
		return produitDao.update(produit);
	}
	
	// Methode pour rendre la liste complete des produits
	public ArrayList<Produit> findAll() {
		return (ArrayList<Produit>) produitDao.findAll();
	}

	// Methode pour trouver dans la BdD un produit d'id connu
	public Produit findById(int id) {
		return produitDao.findById(id);
	}
	
	// Methode pour trouver les produits disponibles
	public ArrayList<Produit> findDisponibles() {
		return (ArrayList<Produit>) produitDao.findDisponibles();
	}
	
	// Methode pour trouver les produits indisponibles
	public ArrayList<Produit> findIndisponibles() {
		return (ArrayList<Produit>) produitDao.findIndisponibles();
	}
	
	// Methode pour trouver les produits d'un vendeur
	public ArrayList<Produit> findByVendeur(int idVendeur) {
		return (ArrayList<Produit>) produitDao.findByVendeur(idVendeur);
	}
	
	// Methode pour trouver les produits disponibles d'un vendeur
	public ArrayList<Produit> findDisponiblesOfVendeur(int idVendeur) {
		return (ArrayList<Produit>) produitDao.findDisponiblesByVendeur(idVendeur);
	}
	
	// Methode pour trouver les produits indisponibles d'un vendeur
	public ArrayList<Produit> findIndisponiblesOfVendeur(int idVendeur) {
		return (ArrayList<Produit>) produitDao.findIndisponiblesByVendeur(idVendeur);
	}
	
	// Methode pour trouver un produit par nom
	public ArrayList<Produit> findByName(String nom) {
		return (ArrayList<Produit>) produitDao.findByNom(nom);
	}
	
	// Methode pour trouver un produit par categorie (mono-catégorie)
	public ArrayList<Produit> findByCategories(int idCategorie) {
		return (ArrayList<Produit>) produitDao.findByCategorie(idCategorie);
	}
	
	// Methode pour trouver un produit par categorie (multi-catégorie)
	public ArrayList<Produit> findByCategories(ArrayList<Integer> idCategories) {
		return (ArrayList<Produit>) produitDao.findByCategories(idCategories);
	}
	
	// Methode pour filtrer une liste de produits selon disponibilite
	public ArrayList<Produit> filterDisponibles(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsDisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() > 0) {
				listeProduitsDisponibles.add(prod);
			}
		return listeProduitsDisponibles;
	}
	
	// Methode pour filtrer une liste de produits selon indisponibilite
	public ArrayList<Produit> filterIndisponibles(ArrayList<Produit> listeProduits) {
		ArrayList<Produit> listeProduitsIndisponibles = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getQuantiteEnStock() == 0) {
				listeProduitsIndisponibles.add(prod);
			}
		return listeProduitsIndisponibles;
	}
	
	// Methode pour filtrer une liste de produits selon le vendeur
	public ArrayList<Produit> filterVendeur(ArrayList<Produit> listeProduits, int idVendeur) {
		ArrayList<Produit> listeProduitsVendeur = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getIdVendeur() == idVendeur) {
				listeProduitsVendeur.add(prod);
			}
		return listeProduitsVendeur;
	}
	
	// Methode pour filtrer une liste de produits selon la designation
	public ArrayList<Produit> filterName(ArrayList<Produit> listeProduits, String nom) {
		ArrayList<Produit> listeProduitsDesignation = new ArrayList<Produit>();
		for (Produit prod : listeProduits)
			if (prod.getDesignation().toLowerCase().contains(nom.toLowerCase())) {
				listeProduitsDesignation.add(prod);
			}
		return listeProduitsDesignation;
	}
	
	// Methode pour filtrer une liste de produits selon des categories
	public ArrayList<Produit> filterCategories(ArrayList<Produit> listeProduits, ArrayList<Integer> idCategories) {
		ArrayList<Produit> listeProduitsCategories = new ArrayList<Produit>();
		boolean test;
		for (Produit prod : listeProduits) {
			test = true;
			for (int idCate : idCategories) {
				if (!prod.getIdCategories().contains(idCate)) {
					test = false;
				}
			}
			if (test) {
				listeProduitsCategories.add(prod);
			}
		}
		return listeProduitsCategories;
	}
}
