### HW15:
* Use your own Observable (class) and Observer (interface).
        * c.f. HW 1
* Your Observable is not thread-safe.
* Revise it to be thread-safe.
    * Use AtomicBoolean to define the data field changed.
    * Use ReentrantLock, not the synchronized keyword, to guard a shared data field (i.e. a LinkedList of observers).
    * Do an open call in notifyObservers() to avoid potential deadlocks.