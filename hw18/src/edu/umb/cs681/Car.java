package edu.umb.cs681;

public class Car {
	
	private int price;
	private String maker;
	
	public Car(int price, String maker) {
		this.maker = maker;
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaker() {
		return maker;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	
	
	
}
