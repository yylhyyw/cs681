### HW7:

* Implement File, Editor and AutoSaver in a thread-safe
manner
    * Define a `ReentrantLock` in File. Use the lock in `change()` and `save()`
    * c.f. `deposit()` and `withdraw()`, which use a lock to access a shared variable in the bank account example
    * Use `try-finally` blocks: Always do this in all subsequent HWs.
* Create two extra threads and have them execute Editor’s run() and AutoSaver’s run()
* Those threads acquire and release the lock in change() and save()

* Files:
    * File.java(include main method)
    * Editor.java
    * AutoSaver.java