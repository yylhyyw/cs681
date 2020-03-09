package edu.umb.cs681;


public class StockQuoteObservable extends Observable {
	
	public void setQuote() {
		this.setChanged();
	}
}

