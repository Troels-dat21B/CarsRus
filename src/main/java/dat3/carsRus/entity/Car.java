package dat3.carsRus.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    private String brand;

    private String model;

    private int pricePerDay;

    private int bestDiscount;

    private LocalDateTime reservation;

    private LocalDate rental;

    @CreationTimestamp
    @Column(name = "Created")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(name = "Edited")
    private LocalDateTime edited;

    public Car(String brand, String model, int pricePerDay, int bestDiscount) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setCar(this);
    }


}
