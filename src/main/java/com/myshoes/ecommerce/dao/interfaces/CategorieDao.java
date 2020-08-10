package com.myshoes.ecommerce.dao.interfaces;

import java.util.List;

import com.myshoes.ecommerce.model.Categorie;
import com.myshoes.ecommerce.model.Product;

public interface CategorieDao {

	void saveCategorie(Categorie categorie);
	
	void deleteCategorie(Long idCategorie);
	
	void UpdateCategorie(Categorie categorie);
	
	List<Categorie> findAllCategories();
	
	Categorie findCategorieById(Long idCategorie);
	
	List<Categorie> findCategoriesByName(String name);
	
	List<Product> findProductsByIdCategorie(Long idCategorie);
}
