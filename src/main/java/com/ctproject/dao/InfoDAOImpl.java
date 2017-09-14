package com.ctproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctproject.model.Product;

@Repository("infoDAO")
public class InfoDAOImpl extends AbstractDao<Integer, Product> implements InfoDAO {
	
	public Product findByCode(String code) {
		return getByCode(code);
	}
	public void delete(Product product){
		delete(product);
	}
	
	@SuppressWarnings("unchecked")
	public List<Product> listInfo() {
		List<Product> infoList = getSession().createQuery("from Product").list();
		return infoList;
	}

	@SuppressWarnings("unchecked")
	public List<Product> searchInfo(String str) {
		List<Product> infoList = getSession().createQuery("FROM Product WHERE name LIKE '%"+str+"%'").list();
		return infoList;
		
	}


}
