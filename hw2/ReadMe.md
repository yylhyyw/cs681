### HW2: 

* Implement your own `min()`, `max()` and `count()` with
`reduce()` for a stream of Car instances.
    * Implementing `min()` with `reduce()`
    * ```
        Integer price = cars.stream()
            .map((Car car)-> car.getPrice())
            .reduce(0, (result, carPrice)->{
                if(result==0) return carPrice;
                else if(carPrice < result) return carPrice;
                else return result;} );```

* Files: 
    * Car.java 
    * CarCompare.java(Include Main method)