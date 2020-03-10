package edu.umb.cs681;

import java.util.Date;

public class Stock {
	
	private String name;
	private float openPrice;
	private float closePrice;
	private Date date;
	
	public Stock(String name, float openPrice, float closePrice, Date date) {
		this.name = name;
		this.openPrice = openPrice;
		this.closePrice = closePrice;
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public float getOpenPrice() {
		return openPrice;
	}
	public float getClosePrice() {
		return closePrice;
	}
	public Date getDate() {
		return date;
	}
	
	
}
