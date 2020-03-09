package edu.umb.cs681;

public class Client {
	public static void main(String[] args) {
		
		System.out.println("StockQuoteObservable Client -------------------------:");
		
		StockQuoteObservable stockquoteobservable = new StockQuoteObservable();
		stockquoteobservable.addObserver(
				(Observable o, Object obj)->{System.out.println("Updated Pie Chart Stock Observer --" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.addObserver(
				(Observable o, Object obj)->{System.out.println("Updated Table Stock Observer --" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.addObserver(
				(Observable o, Object obj)->{System.out.println("Updated 3D Stock Observer --" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.setQuote();
		stockquoteobservable.notifyObservers(new StockEvent("AAPL", 300f));
		
		System.out.println("DJAQuoteObservable Client -------------------------:");
		
		DJIAQuoteObservable DJIAquoteobservable = new DJIAQuoteObservable();
		DJIAquoteobservable.addObserver(
				(Observable o, Object obj)->{System.out.println("Updated Pie Chart DJIA Observer --" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.addObserver(
				(Observable o, Object obj)->{System.out.println("Updated Table DJIA Observer --" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.addObserver(
				(Observable o, Object obj)->{System.out.println("Updated 3D Chart DJIA Observer --" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.setQuote();
		DJIAquoteobservable.notifyObservers(new DJIAEvent(23782.68f));
		
		
	}

}


class StockEvent {
	private String ticker;
	private float quote;
	public StockEvent(String t, float q) {
		this.ticker = t;
		this.quote = q;
	}
	public String getTicker() {
		return ticker;
	}
	public float getQuote() {
		return quote;
	}
}
class DJIAEvent {
    private float djia;
	
	public float getDjia() {
		return djia;
	}
	public DJIAEvent(float djia)
	{
		this.djia = djia;
	}

	public void setDjia(float djia) {
		this.djia = djia;
	}
}