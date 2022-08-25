package dat3.carsRus.entity;

import javax.persistence.Entity;

@Entity
public class Car {

    private String brand;

    private String model;

    private int pricePerDay;

    private int bestDiscount;

    public Car(String brand, String model, int pricePerDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }

    public Car(){};


}
