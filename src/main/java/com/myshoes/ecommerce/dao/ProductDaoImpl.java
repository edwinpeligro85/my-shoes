package com.myshoes.ecommerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myshoes.ecommerce.dao.interfaces.ProductDao;
import com.myshoes.ecommerce.model.Product;

@Repository
@Transactional
public class ProductDaoImpl extends AbstractSession implements ProductDao {

	@Override
	public void saveProduct(Product product) {
		getSession().persist(product);
	}

	@Override
	public void deleteProduct(Long idProduct) {
		Product product = this.findProductById(idProduct);
		
		if (product != null) {
			getSession().delete(product);
		}
	}

	@Override
	public void UpdateProduct(Product product) {
		getSession().update(product);
	}

	@Override
	public List<Product> findAllProducts() {
		return getSession().createQuery("from Product").list();
	}

	@Override
	public Product findProductById(Long idProduct) {
		return (Product) getSession().get(Product.class, idProduct);
	}

	@Override
	public List<Product> findProductsByname(String displayName) {
		return (List<Product>) getSession().createQuery("from Product where displayName like :name")
				.setParameter("name", '%' + displayName + '%').list();
	}
}
