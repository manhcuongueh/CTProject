package com.ctproject.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctproject.model.OrderDetail;


@Repository("orderDetailDAO")
public class OrderDetailDAOImpl extends AbstractDao<Integer, OrderDetail> implements OrderDetailDAO{
	
	public void saveOrder(OrderDetail orderde){
		persist(orderde);
	}
	
	public void deleteOrder(OrderDetail orderde){
		delete(orderde);
	}
	
	@SuppressWarnings("unchecked")
	public List<OrderDetail> getOrderDetail(int id){
		List<OrderDetail> Orderdetail = getSession().createQuery("FROM Orderdetail WHERE id LIKE '"+id+"'").list();
		return Orderdetail;
	}

}
