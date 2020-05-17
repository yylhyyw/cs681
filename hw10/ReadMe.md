### HW10:

* Revise ConcurrentSingleton
    * Use `AtomicReference` to define instance
    * Take out `ReentrantLock`
    * Implement getInstance() in a thread-safe manner with AtomicReference’s methods.

* Files:
    * ConcurrentSingleton.java(include main method)