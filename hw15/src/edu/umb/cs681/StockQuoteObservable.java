package edu.umb.cs681;


public class StockQuoteObservable extends ThreadSafeObservable {
	
	public void setQuote() {
		this.setChanged();
	}
}

