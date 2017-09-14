package com.ctproject.service;

import java.util.List;

import com.ctproject.model.Product;

public interface InfoService {

	Product findByCode(String code);
	List<Product> listInfo();
	void delete(Product product);
	List<Product> searchInfo(String str);
	
}
