package edu.umb.cs681;

import java.util.LinkedList;

public class Client {
	public static void main(String[] args) {
		System.out.println("Factorization of 36");
		RunnableCancellablePrimeFactorizer runnable = new RunnableCancellablePrimeFactorizer(36, 2, (long)Math.sqrt(36));
		Thread thread = new Thread(runnable);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + "->" + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final result: " + runnable.getPrimeFactors() + "\n");
		
		// Factorization of 84 with two threads
		System.out.println("Factorization of 84");
		LinkedList<RunnableCancellablePrimeFactorizer> runnables = new LinkedList<RunnableCancellablePrimeFactorizer>();
		LinkedList<Thread> threads = new LinkedList<Thread>();

		runnables.add( new RunnableCancellablePrimeFactorizer(84, 2, (long)Math.sqrt(84)/2 ));
		runnables.add( new RunnableCancellablePrimeFactorizer(84, 1+(long)Math.sqrt(84)/2, (long)Math.sqrt(84) ));
		
		thread = new Thread(runnables.get(0));
		threads.add(thread);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnables.get(0).getFrom() + "->" + runnables.get(0).getTo());
		
		thread = new Thread(runnables.get(1));
		threads.add(thread);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnables.get(1).getFrom() + "->" + runnables.get(1).getTo());
		
		threads.forEach( (t)->t.start() );
		
		// the second thread should stop here:
		System.out.println("Thread #" + thread.getId() + 
				" should stop here.");
		runnables.get(1).setDone();
		
		threads.forEach( (t)->{	try{t.join();}
								catch(InterruptedException e){e.printStackTrace(); }} );
		
		LinkedList<Long> factors = new LinkedList<Long>();
		runnables.forEach( (factorizer) -> factors.addAll(factorizer.getPrimeFactors()) );
		System.out.println("Final result: " + factors + "\n");
		
		runnables.clear();
		threads.clear();
		
		// Factorization of 2489 with two threads
		System.out.println("Factorization of 2489");
		runnables.add( new RunnableCancellablePrimeFactorizer(2489, 2, (long)Math.sqrt(2489)/2 ));
		runnables.add( new RunnableCancellablePrimeFactorizer(2489, 1+(long)Math.sqrt(2489)/2, (long)Math.sqrt(2489) ));
		
		thread = new Thread(runnables.get(0));
		threads.add(thread);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnables.get(0).getFrom() + "->" + runnables.get(0).getTo());
		
		thread = new Thread(runnables.get(1));
		threads.add(thread);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnables.get(1).getFrom() + "->" + runnables.get(1).getTo());
		
		threads.forEach( (t)->t.start() );
		
		// the first thread should stop here:
		System.out.println("Thread #" + thread.getId() + 
				" should stop here.");
		runnables.get(0).setDone();
		
		threads.forEach( (t)->{	try{t.join();}
								catch(InterruptedException e){e.printStackTrace(); }} );
		
		LinkedList<Long> factors2 = new LinkedList<Long>();
		runnables.forEach( (factorizer) -> factors2.addAll(factorizer.getPrimeFactors()) );
		System.out.println("Final result: " + factors2);		
	}
}
