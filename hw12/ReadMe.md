### HW12:

* Implement AccessCounter as a `thread-safe` Singleton class`.
    * Define a `HashMap<java.nio.file.Path, Integer>`
    * Define a `regular (non-static) lock` and use the `lock` in `increment()` and `getCount()`
* Define another `(static) lock` and use the lock in getInstance()
    * Place some test/dummy files
* AccessCounter.class
    RequestHandler.class
    a.html
    b.html
    ...
* RequestHandler (Runnable class)
    * run(): Picks up one of the files at random, calls increment() and getCount() for that file, and sleeps for a few seconds. Repeats this forever with an infinite loop.
* main(): Test code
    * Creates 10+ instances of RequestHandler and use 10+ threads to execute RequestHandler’s run().
    * Implement 2-step thread termination in RequestHandler.
* Have the main thread terminate those 10+ extra threads in 2 steps.


* Files:
    * AccessCounter.java
    * Client.java (include main method)
    * RequestHandler.java
    * a.html
    * b.html
    * c.html
    * d.html
    * e.html