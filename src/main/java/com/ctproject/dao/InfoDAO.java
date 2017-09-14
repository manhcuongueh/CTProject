package com.ctproject.dao;

import java.util.List;

import com.ctproject.model.Product;

public interface InfoDAO {
	
	Product findByCode(String code);
	public List<Product> listInfo();
	void delete(Product product);
	public List<Product> searchInfo(String str);
}
