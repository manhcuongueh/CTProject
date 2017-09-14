package com.ctproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctproject.dao.InfoDAO;
import com.ctproject.model.Product;

@Service("infoService")
@Transactional
public class InfoServiceImpl implements InfoService {
	
	@Autowired
	private InfoDAO infoDAO;
	
	public Product findByCode(String code){
		return this.infoDAO.findByCode(code);
	}

	
	public List<Product> listInfo() {
		return this.infoDAO.listInfo();
	}

	public void delete(Product product){
		infoDAO.delete(product);
	}
	
	public List<Product> searchInfo(String str) {
		return this.infoDAO.searchInfo(str);
	}


}
