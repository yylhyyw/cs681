package edu.umb.cs681;

public class DJIAQuoteObservable extends ThreadSafeObservable {

	public void setQuote()
	{	
        setChanged();
	}

}