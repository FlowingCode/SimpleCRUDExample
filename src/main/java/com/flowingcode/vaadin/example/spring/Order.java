package com.flowingcode.vaadin.example.spring;

import java.time.LocalDate;

public class Order {

	int       quantity;
	String    description;
	LocalDate dueDate;
	State     state;
	boolean   priority;

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
    public State getState() {
		return state;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
    public boolean isPriority() {
		return priority;
	}
	public void setPriority(boolean priority) {
		this.priority = priority;
	}
	
}