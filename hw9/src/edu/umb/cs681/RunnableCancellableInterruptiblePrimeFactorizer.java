package edu.umb.cs681;

import java.util.concurrent.locks.ReentrantLock;

public class RunnableCancellableInterruptiblePrimeFactorizer extends RunnableCancellablePrimeFactorizer{
	
	private boolean done = false;
	private ReentrantLock lock = new ReentrantLock();
	
	public RunnableCancellableInterruptiblePrimeFactorizer(long dividend, long from, long to) {
		super(dividend, from, to);
	}
	
	public void setDone() {
		lock.lock();
		try {
			done = true;
		}finally {
			lock.unlock();
		}
	}
	
	@Override
	public void generatePrimeFactors() {
		long divisor = 2;
	    while( dividend != 1 && divisor <= to ){
	    	lock.lock();
	    	try {
	    		if(Thread.interrupted()){
					System.out.println("Stopped generating prime numbers Factors due to a thread interruption.");
					this.factors.clear();
					break;
				}
	    		if(done) {
	    			System.out.println("Stopped...");
	    			break;
	    		}
			    if(dividend % divisor == 0) {
			        factors.add(divisor);
			        dividend /= divisor;
			    }else {
			    	if(divisor==2){ divisor++; }
			    	else{ divisor += 2; }
			    	
			    }
	    	}finally {
	    		lock.unlock();
	    	}

		}
	}
	
	public static void main(String[] args) {
		RunnableCancellableInterruptiblePrimeFactorizer gen = new RunnableCancellableInterruptiblePrimeFactorizer(36, 2, (long)Math.sqrt(36));
		Thread thread = new Thread(gen);
		thread.start();
		thread.interrupt();
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Final result: " + gen.getPrimeFactors() + "\n");
	}
}
