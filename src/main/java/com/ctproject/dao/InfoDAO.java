package com.ctproject.dao;

import java.util.List;


import com.ctproject.model.Product;

public interface InfoDAO {
	
	void saveProduct(Product pro);
	void updateProduct(Product pro);
	
	Product findByCode(String code);
	public List<Product> listInfo();
	void delete(String code);
	public List<Product> searchInfo(String str);
}
