### HW8:
* Implement ConcurrentSingleton.
    * Define a `lock` in `ConcurrentSingleton` . Use the `lock` in `getInstance()` to guard instance
        * Use try-finally blocks: Always do this in all subsequent HWs.
* Run multiple threads to call getInstance()
    * Make sure that only one instance is created.
        * Use System.out.println(Singleton.getInstance())

* Files:
    ConcurrentSingleton.java(include main method)