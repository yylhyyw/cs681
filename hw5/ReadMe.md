### HW5:
* Revise RunnableCancellablePrimeGenerator to be
thread-safe.
    * Add a `ReentrantLock` to guard the
shared variable done
    * Revise `generatePrimes()` and `setDone()` to access done with the lock

* Files:
    * Client.java (include main method, cancel thread in 1 Sec)
    * PrimeGenerator.java
    * RunnableCancellablePrimeGenerator.java
    * RunnablePrimeGenerator.java