package com.myshoes.ecommerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myshoes.ecommerce.dao.interfaces.CategorieDao;
import com.myshoes.ecommerce.model.Categorie;
import com.myshoes.ecommerce.model.Product;

@Repository
@Transactional
public class CategorieDaoImpl extends AbstractSession implements CategorieDao {

	@Override
	public void saveCategorie(Categorie categorie) {
		getSession().persist(categorie);
	}

	@Override
	public void deleteCategorie(Long idCategorie) {
		Categorie categorie = this.findCategorieById(idCategorie);
		
		if (categorie != null) {
			getSession().delete(categorie);
		}
	}

	@Override
	public void UpdateCategorie(Categorie categorie) {
		getSession().update(categorie);
	}

	@Override
	public List<Categorie> findAllCategories() {
		return getSession().createQuery("from Categorie").list();
	}

	@Override
	public Categorie findCategorieById(Long idCategorie) {
		return (Categorie) getSession().get(Categorie.class, idCategorie);
	}

	@Override
	public List<Categorie> findCategoriesByName(String name) {
		return (List<Categorie>) getSession().createQuery("from Categorie where displayName like :name")
				.setParameter("name", '%' + name + '%').list();
	}
	
	@Override
	public List<Product> findProductsByIdCategorie(Long idCategorie) {
		return (List<Product>) getSession().createQuery("from Product p join p.categorie c where c.idCategorie = :id")
				.setParameter("id", idCategorie).list();
	}


}