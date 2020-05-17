### ReadMe
* CS681 HW6
    * Use Implement flag-based thread termination.
    * Add a flag variable done
    * Add a `ReentrantLock` to guard the shared variable `done`
    * Revise `generatePrimeFactors()` and `setDone()` to access done with the lock
    * Call `unlock()` in finally block


* Files: 
    * Client.java(include main method)
    * PrimeFactorizer.java
    * RunnableCancellablePrimeFactorizer.java
    * RunnablePrimeFactorizer.java