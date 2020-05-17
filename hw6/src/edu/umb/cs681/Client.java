package edu.umb.cs681;

import java.util.LinkedList;

public class Client {
	public static void main(String[] args) {
		System.out.println("Factorization of 36");
		RunnableCancellablePrimeFactorizer runnable = new RunnableCancellablePrimeFactorizer(36, 2, 36);
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
		
		// Factorization of 84
		System.out.println("Factorization of 84");
		runnable = new RunnableCancellablePrimeFactorizer(84, 2, 84);
		thread = new Thread(runnable);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + "->" + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final result: " + runnable.getPrimeFactors() + "\n");
		
		// Factorization of 2489
		System.out.println("Factorization of 2489");
		runnable = new RunnableCancellablePrimeFactorizer(2489, 2, 2489);
		thread = new Thread(runnable);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + "->" + runnable.getTo());
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final result: " + runnable.getPrimeFactors() + "\n");	


		// Factorization of 2489, but canncel immediately
		System.out.println("Factorization of 2489, but canncel immediately");
		runnable = new RunnableCancellablePrimeFactorizer(2489, 2, 2489);
		thread = new Thread(runnable);
		System.out.println("Thread #" + thread.getId() + 
			" performs factorization in the range of " + runnable.getFrom() + "->" + runnable.getTo());
		thread.start();
		runnable.setDone();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Final result: " + runnable.getPrimeFactors() + "\n");	
	}
}
