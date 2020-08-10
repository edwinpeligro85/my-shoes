package com.myshoes.ecommerce.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshoes.ecommerce.dao.interfaces.CategorieDao;
import com.myshoes.ecommerce.model.Categorie;
import com.myshoes.ecommerce.model.Product;
import com.myshoes.ecommerce.service.interfaces.CategorieService;

@Service("categorieService")
@Transactional
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDao _categorieDao;
	
	@Override
	public void saveCategorie(Categorie categorie) {
		this._categorieDao.saveCategorie(categorie);
	}

	@Override
	public void deleteCategorie(Long idCategorie) {
		this._categorieDao.deleteCategorie(idCategorie);
	}

	@Override
	public void UpdateCategorie(Categorie categorie) {
		this._categorieDao.UpdateCategorie(categorie);
	}

	@Override
	public List<Categorie> findAllCategories() {
		return this._categorieDao.findAllCategories();
	}

	@Override
	public Categorie findCategorieById(Long idCategorie) {
		return this._categorieDao.findCategorieById(idCategorie);
	}

	@Override
	public List<Categorie> findCategoriesByName(String name) {
		return this._categorieDao.findCategoriesByName(name);
	}

	@Override
	public List<Product> findProductsByIdCategorie(Long idCategorie) {
		return this._categorieDao.findProductsByIdCategorie(idCategorie);
	}

}
