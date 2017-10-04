package com.ctproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ctproject.model.Product;

@Repository("infoDAO")
public class InfoDAOImpl extends AbstractDao<Integer, Product> implements InfoDAO {
	
	public void saveProduct(Product pro){
		persist(pro);
	}
	public void updateProduct(Product pro){
		update(pro);
		
	}
	
	
	public Product findByCode(String code) {
		return getByCode(code);
	}
	public void delete(String code){
		Query query = getSession().createSQLQuery("DELETE FROM Product WHERE code LIKE '"+code+"'");
		query.executeUpdate();
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
