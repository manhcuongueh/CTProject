package com.ctproject.service;

import java.util.List;

import com.ctproject.model.Product;

public interface InfoService {

	void saveProduct(Product pro);
	void updateProduct(Product pro);
	Product findByCode(String code);
	List<Product> listInfo();
	void delete(String code);
	List<Product> searchInfo(String str);
	
}
