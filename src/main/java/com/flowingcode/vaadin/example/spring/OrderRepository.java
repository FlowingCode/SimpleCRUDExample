package com.flowingcode.vaadin.example.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

	private List<Order> orders = new ArrayList<>(); 
	
	public List<Order> getAll() {
		return new ArrayList<>(orders);
	}
	
	public void add(Order pedido) {
		orders.add(pedido);
	}
	
	public void remove(Order pedido) {
		orders.remove(pedido);
	}
		
}
