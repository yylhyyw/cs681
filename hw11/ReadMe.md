### HW11: 
* Implement your own `immutable class`:
    ```
    public final class Address {
        private final String street, city, state;
        private final int zipcode;
        ... }
    ```
* Define a constructor that takes `4` parameters and initializes an address.
    * Define getter methods for those 4 data fields
    * Define equals() and toString()
        * c.f. SSN’s equals() and toString()
    * Define change() to change the current address
        ```
        public Address change(String street, String city, String state, int zipcode){
            return new Address(street, city, state, zipcode); }
        ```
    * It sounds like a setter, but it is NOT. It creates a new instance and `returns` it.
        ```
        public class Customer {
            private Address address; // Shared (non-final) variable
            public Customer(Address addr){ address = addr; }
            public Address setAddress(Address addr){ address = addr; // Customer needs a setter. // 2 steps; NOT thread-safe. }
        public Address getAddress(){ // 2 steps; NOT thread-safe.
            return address;
        } }
        Customer customer = new Customer( new Address( ... ) );
        customer.getAddress();
        customer.setAddress( new Address ( ...) );
        customer.setAddress( customer.getAddress().change( ... ) );
        ```
Customer requires thread synchronization to guard address, although Address does not.
* Turn in
    * `Immutable Address`
    * `Thread-safe` Customer, which…
        * has a `ReentrantLock` as a data field and performs thread synchronization with it, OR
        * uses `AtomicReferenceType<Address>` and skips thread synchronization.
    * Runnable class whose run() calls Customer’s setAddress() and getAddress()
        * You can replace the Runnable class with a lambda expression, if you like
    * Test code to create and run multiple threads


* Files:
    * Address.java
    * Client.java (include main method)
    * Customer.java