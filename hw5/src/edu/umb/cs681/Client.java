package edu.umb.cs681;

public class Client {
	public static void main(String[] args) {
		long before = System.currentTimeMillis();
		RunnableCancellablePrimeGenerator gen1 = new RunnableCancellablePrimeGenerator(1L, 2000000L);
		Thread t1 = new Thread(gen1);
		
		t1.start();
		while(true) {
			long after = System.currentTimeMillis();
			if((after - before) == 1000) break;
		}
		gen1.setDone();
		System.out.println("cancel thread in 1 sec.");
		try {
			t1.join();
		} catch (InterruptedException e) {}
		
		gen1.getPrimes().forEach((Long prime) -> System.out.print(prime + ", "));
		System.out.println("\n" + gen1.getPrimes().size() + " prime numbers are found in 1 Sec.");
	}
}
