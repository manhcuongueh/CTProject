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

	public void saveProduct(Product pro){
		infoDAO.saveProduct(pro);
	}
	public void updateProduct(Product pro){
		infoDAO.updateProduct(pro);
	}
	public List<Product> listInfo() {
		return this.infoDAO.listInfo();
	}

	public void delete(String code){
		infoDAO.delete(code);
	}
	
	public List<Product> searchInfo(String str) {
		return this.infoDAO.searchInfo(str);
	}


}
