### HW16:

* Revise your concurrent access counter (HW 12 solution) with ConcurrentHashMap
    * Eliminate client-locking (to guard a hash map) in increment() and getCount()
    * i.e., AccessCounter no longer needs a ReentrantLock data field.
* Use lambda expressions whenever possible.

* Files:
    * AccessCounter.java
    * Client.java (include main method)
    * RequestHandler.java