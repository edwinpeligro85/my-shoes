package com.myshoes.ecommerce.dao.interfaces;


import java.util.List;

import  com.myshoes.ecommerce.model.Customer;
import com.myshoes.ecommerce.model.Favorite;

public interface CustomerDao {
	
	void saveCustomer(Customer customer);
	
	void deleteCustomer(Long idCustomer);
	
	void UpdateCustomer(Customer customer);
	
	List<Customer> findAllCustomers();
	
	Customer findCustomerById(Long idCustomer);
	
	List<Favorite> findFavoritesByIdCustomer(Long idCustomer);
}
