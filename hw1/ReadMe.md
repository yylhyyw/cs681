### HW 1: Implement Observer with LEs

* Define your own `Observable (class)` and `Observer (interface)`
    * DO NOT reuse `java.util.Observable` and `java.util.Observer`
    * Define `Observable` as an `abstract class`.
    * Define `Observer` as a `functional interface`.
    * `update()` as the only `abstract method` in that interface.
    * Implement all the methods that are available in
        `java.util.Observable`
    * c.f. Java API doc for expected behaviors/responsibilities of the methods
    * Use `LinkedList` to hold all registered observers.
    * c.f. CS680 slides on “ArrayList v.s. LinkedList”
* Files: 
    * Client.java(include Main Method) 
    * DJIAQuoteObservable.java
    * Observable.java
    * Observer.java
    * StockQuoteObservable.java