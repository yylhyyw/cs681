package edu.umb.cs681;

import java.util.Random;

public class Client {
	public static void main(String[] args) {
		
		System.out.println("StockQuoteObservable Client -------------------------:");
		
		StockQuoteObservable stockquoteobservable = new StockQuoteObservable();
		stockquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("Updated Pie Chart Stock Observer --" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("Updated Table Stock Observer --" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.println("Updated 3D Stock Observer --" + " Stock Name: " + ((StockEvent)obj).getTicker() + " Stock Price: " + ((StockEvent)obj).getQuote());}
				);
		stockquoteobservable.setQuote();
		stockquoteobservable.notifyObservers(new StockEvent("AAPL", 300f));
		
		System.out.println("DJAQuoteObservable Client -------------------------:");
		
		DJIAQuoteObservable DJIAquoteobservable = new DJIAQuoteObservable();
		DJIAquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("Updated Pie Chart DJIA Observer --" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.print("Updated Table DJIA Observer --" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.addObserver(
				(ThreadSafeObservable o, Object obj)->{System.out.println("Updated 3D Chart DJIA Observer --" + " Quote: " + ((DJIAEvent)obj).getDjia());}
				);
		DJIAquoteobservable.setQuote();
		DJIAquoteobservable.notifyObservers(new DJIAEvent(23782.68f));
		
	
		Thread[] sqThreads = new Thread[10];
		Thread[] djiThreads = new Thread[10];
		for(int i = 0; i < 10; i++) {
			Random random = new Random();
			float sqFloatRandom = random.nextFloat()*10f + 300f; 
			float djiFloatRandom = random.nextFloat()*100f + 23000f; 
			sqThreads[i] = new Thread(() ->{
				stockquoteobservable.setQuote();
				stockquoteobservable.notifyObservers(new StockEvent("AAPL", sqFloatRandom));
				
			});
			sqThreads[i].start();
			djiThreads[i] = new Thread(() ->{
				DJIAquoteobservable.setQuote();
				DJIAquoteobservable.notifyObservers(new DJIAEvent(djiFloatRandom));
				
			});
			djiThreads[i].start();
		}
		
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int i = 0; i < 10; i++){
			try {
				sqThreads[i].join();
				djiThreads[i].join();
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
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