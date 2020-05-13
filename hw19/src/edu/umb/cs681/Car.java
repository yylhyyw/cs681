package edu.umb.cs681;

public class Car {
	
	private int price;
	private String maker;
	private String model;
	
	public Car(int price, String maker, String model) {
		this.maker = maker;
		this.price = price;
		this.model = model;
	}
	public int getPrice() {
		return price;
	}
	public String getModel() {
		return model;
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
