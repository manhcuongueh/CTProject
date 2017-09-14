package com.ctproject.service;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctproject.dao.OrderDetailDAO;
import com.ctproject.model.OrderDetail;

@Service("orderDetailService")
@Transactional

public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Autowired
	OrderDetailDAO orderdetailDAO;
	
	public void saveOrder(OrderDetail orderde){
		orderdetailDAO.saveOrder(orderde);
	}
	
	public void deleteOrder(OrderDetail orderde){
		orderdetailDAO.deleteOrder(orderde);
	}
	
	public List<OrderDetail> getOrderDetail(String id){
		return orderdetailDAO.getOrderDetail(id);
	}

}
