package edu.umb.cs681;

import java.util.LinkedList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class CallablePrimeGenerator extends PrimeGenerator implements Callable<LinkedList<Long>> {
	
	public CallablePrimeGenerator(long from, long to) {
		super(from, to);
	}

	public static void main(String[] args) {
		long startTime = System.nanoTime();
		LinkedList<Long> allPrimes = new LinkedList<>();
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		ExecutorCompletionService<LinkedList<Long>> completionService = new ExecutorCompletionService<>(executor);
// two threads
		CallablePrimeGenerator gen1 = new CallablePrimeGenerator(1L, 5000L);
		CallablePrimeGenerator gen2 = new CallablePrimeGenerator(5000L, 10000L);
		completionService.submit(gen1);
		completionService.submit(gen2);
		
        for(int completed=0; completed<2; completed++) {
        	try {
				Future<LinkedList<Long>> future = completionService.take();
				allPrimes.addAll(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
        }
		
		allPrimes.forEach( (Long prime)->{System.out.print(prime +",");} );

		long endTime = System.nanoTime();
		double duration = ((double)(endTime - startTime))/1000000000.0;
		System.out.println("It takes " + duration + " s to run.");
		executor.shutdown();
	}

	@Override
	public LinkedList<Long> call() throws Exception {
		generatePrimes();
		return getPrimes();
	}

}
