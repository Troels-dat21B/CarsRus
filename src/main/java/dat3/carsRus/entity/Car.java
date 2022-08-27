package dat3.carsRus.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String brand;

    private String model;

    private int pricePerDay;

    private int bestDiscount;

    @CreationTimestamp
    @Column(name = "Oprettet")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "Sidste ændret")
    private LocalDateTime edited;

    public Car(String brand, String model, int pricePerDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }

    public Car(){};

    //region Gettere og Settere

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public int getBestDiscount() {
        return bestDiscount;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getEdited() {
        return edited;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public void setBestDiscount(int bestDiscount) {
        this.bestDiscount = bestDiscount;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setEdited(LocalDateTime edited) {
        this.edited = edited;
    }
    //endregion
}
