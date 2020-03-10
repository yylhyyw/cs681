package edu.umb.cs681;

import java.util.ArrayList;
import java.util.Arrays;

public class CarCompare {
	static ArrayList<Car> cars = new ArrayList<Car>(
			Arrays.asList(
					new Car(30000, "Tesla"),
					new Car(20000, "GM"),
					new Car(22000, "Honda"),
					new Car(40000, "Audi")));
	public static void main(String args[]) {
		System.out.println("Value in cars list with value:\n");
		System.out.println("Tesla with price 30000");
		System.out.println("GM with price 20000");
		System.out.println("Honda with price 22000");
		System.out.println("Audi with price 40000\n");
		System.out.println("Min Price Method result --------: ");
		Integer minPrice = cars.stream()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, carPrice)->{
				if(result==0) return carPrice;
				else if(carPrice < result) return carPrice; else return result;} );
		System.out.println("The Min price: " + minPrice);
		System.out.println("Max Price Method result --------: ");
		Integer maxPrice = cars.stream()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, carPrice) -> {
					if(result == 0) return carPrice;
					else if(carPrice >= result) return carPrice;
					else return result;
				});
		System.out.println("The Max price: " + maxPrice);
		System.out.println("Count Method result --------: ");
		Integer count = cars.stream()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, car) -> {
					if(car != null) return ++result;
					return result;
				});
		System.out.println("The count Method: " + count);
	}
			
}
