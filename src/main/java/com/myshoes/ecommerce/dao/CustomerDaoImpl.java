package com.myshoes.ecommerce.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myshoes.ecommerce.dao.interfaces.CustomerDao;
import com.myshoes.ecommerce.model.Customer;
import com.myshoes.ecommerce.model.Favorite;

@Repository
@Transactional
public class CustomerDaoImpl extends AbstractSession implements CustomerDao {
	
	public void saveCustomer(Customer customer) {
		getSession().persist(customer);
	}

	public void deleteCustomer(Long idCustomer) {
		Customer customer = this.findCustomerById(idCustomer);
		
		if (customer != null) {
			getSession().delete(customer);
		}
	}

	public void UpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		getSession().update(customer);
	}

	public List<Customer> findAllCustomers() {
		return getSession().createQuery("from Customer").list();
	}

	public Customer findCustomerById(Long idCustomer) {
		return  (Customer) getSession().get(Customer.class, idCustomer);
	}

	@Override
	public List<Favorite> findFavoritesByIdCustomer(Long idCustomer) {
		List<Object[]> objects = getSession().createQuery("from Favorite f join f.product where f.idCustomer = :id")
				.setParameter("id", idCustomer).list();
		
		return null;
	}

}
