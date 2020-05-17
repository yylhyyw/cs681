package edu.umb.cs681;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class StockCompare {
	public static void main(String args[]) throws ParseException {
		String sDate = "3 10, 2020";
		SimpleDateFormat formatter = new SimpleDateFormat("MM dd, yyyy");
		Date date = formatter.parse(sDate);  
		ArrayList<Stock> stocks = new ArrayList<Stock>(
				Arrays.asList(
						new Stock("Apple", 277.14f, 285.34f, date),
						new Stock("GE", 8.78f, 8.85f, date),
						new Stock("Google", 1260.00f, 1280.39f, date),
						new Stock("Microsoft", 158.16f, 160.92f, date)));
		System.out.println("input stock data--------------: \n");
		System.out.println("Apple with open price 277.14 closed price 285.34 on date 3 10, 2020");
		System.out.println("GE with open price 8.78 closed price 8.85 on date 3 10, 2020");
		System.out.println("Google with open price 1260.00 closed price 1280.39 on date 3 10, 2020");
		System.out.println("Microsoft with open price 158.16 closed price 160.92 on date 3 10, 2020\n");
		System.out.println("Max increase rate Method result --------: ");
		Float maxIncreaseRate = stocks.stream()
				.parallel()
				.map((Stock stock) -> (stock.getClosePrice()-stock.getOpenPrice())*100/stock.getOpenPrice())
				.reduce(Float.MIN_VALUE, (result, stockRate) -> {
					if(stockRate > result) return stockRate;
					else return result;
				}, (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return (finalResult > interMediateResult)? finalResult:interMediateResult;});
		System.out.println("The Max Increase rate is " + maxIncreaseRate);
		System.out.println("Min increase rate Method result --------: ");
		Float minIncreaseRate = stocks.stream()
				.parallel()
				.map((Stock stock) -> (stock.getClosePrice()-stock.getOpenPrice())*100/stock.getOpenPrice())
				.reduce(Float.MAX_VALUE, (result, stockRate) -> {
					if(stockRate < result) return stockRate;
					else return result;
				}, (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return (finalResult < interMediateResult)? finalResult:interMediateResult;});
		System.out.println("The Min Increase rate is " + minIncreaseRate);
		System.out.println("Count the number of stocks that have increase rate bigger than 2% method result --------: ");
		Integer count = stocks.stream()
				.parallel()
				.map((Stock stock) -> ((stock.getClosePrice()-stock.getOpenPrice())*100/stock.getOpenPrice()) > 2 ? 1 : 0)
				.reduce(0, (result, existed) -> {
					return result + existed;
				}, (finalResult, interMediateResult)->{
			    	System.out.println(Thread.currentThread().getName() + " : finalResult = " + finalResult + "; interMediateResult = " + interMediateResult);
			    	return finalResult+interMediateResult;});
		System.out.println("The Number of stocks with increase rate bigger than 2% is " + count);
	}
	
}
