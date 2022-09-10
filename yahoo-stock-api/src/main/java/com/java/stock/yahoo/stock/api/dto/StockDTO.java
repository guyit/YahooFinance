package com.java.stock.yahoo.stock.api.dto;

import java.math.BigDecimal;
 
public class StockDTO {
	
	private String name;
	private BigDecimal price;
	private BigDecimal change;
	private String currency;
	public StockDTO(String name, BigDecimal price, BigDecimal change, String currency) {
		this.name = name;
		this.price = price;
		this.change=  change;
		this.currency = currency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getChange() {
		return change;
	}
	public void setChange(BigDecimal change) {
		this.change = change;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	@Override
	public String toString() {
		return "StockDTO [name=" + name + ", price=" + price + ", change=" + change + ", currency=" + currency + "]";
	}

	
	
}
