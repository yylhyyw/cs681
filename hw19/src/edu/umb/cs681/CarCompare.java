package edu.umb.cs681;

import java.util.ArrayList;
import java.util.Arrays;

public class CarCompare {
	static ArrayList<Car> cars = new ArrayList<Car>(
			Arrays.asList(
					new Car(30000, "Tesla", "ModelS"),
					new Car(20000, "GM", "Camaro"),
					new Car(22000, "Honda", "Civic"),
					new Car(40000, "Audi", "A4"),
					new Car(41000, "Audi", "A4")));
	public static void main(String args[]) {
		System.out.println("Value in cars list with value:\n");
		System.out.println("Tesla with price 30000");
		System.out.println("GM with price 20000");
		System.out.println("Honda with price 22000");
		System.out.println("Audi with price 40000\n");
		System.out.println("Min Price Method result --------: ");
		Integer minPrice = cars.stream()
				.parallel()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, carPrice)->{
				if(result==0) return carPrice;
				else if(carPrice < result) return carPrice; else return result;},
					    (finalResult, interMediateResult)->{
					    	System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
					    	return (finalResult < interMediateResult)? finalResult:interMediateResult;
					    });
		System.out.println("The Min price: " + minPrice);
		System.out.println("Max Price Method result --------: ");
		Integer maxPrice = cars.stream()
				.map((Car car) -> car.getPrice())
				.parallel()
				.reduce(0, (result, carPrice) -> {
					if(result == 0) return carPrice;
					else if(carPrice >= result) return carPrice;
					else return result;
				}, 					    (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return (finalResult > interMediateResult)? finalResult:interMediateResult;
			    });
		System.out.println("The Max price: " + maxPrice);
		System.out.println("Count Method result --------: ");
		Integer count = cars.stream()
				.parallel()
				.map((Car car) -> car.getPrice())
				.reduce(0, (result, car) -> {
					if(car != null) return ++result;
					return result;
				},										(finalResult,intermediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + intermediateResult);
					return finalResult + intermediateResult;
				});
		System.out.println("The count Method: " + count);
		System.out.println("Count number of models result --------: ");
		Integer numberOfModel = cars.stream()
				.parallel()
				.map((Car car) -> car.getModel())
				.distinct()
				.reduce(0, (result, model) -> {
					return ++result;
				}, (finalResult,intermediateResult) -> {
					System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + intermediateResult);
					return finalResult+intermediateResult;
				});
		
		System.out.println("The Number of Models: " + numberOfModel);
	}
			
}
