package com.jpmorgan.app.model;

import java.util.Date;

public class TradingModel {
	
	private Date timeTrading;
	private Double quantity;
	private Double price;
	private String indicator;
	
	public Date getTimeTrading() {
		return timeTrading;
	}
	public void setTimeTrading(Date timeTrading) {
		this.timeTrading = timeTrading;
	}
	public Double getQuantity() {
		return quantity;
	}
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getIndicator() {
		return indicator;
	}
	public void setIndicator(String indicator) {
		this.indicator = indicator;
	}
	
	
	@Override
	public String toString() {
		return "TradingModel [timeTrading=" + timeTrading + ", quantity=" + quantity + ", price=" + price
				+ ", indicator=" + indicator + "]";
	}
	
	

}
