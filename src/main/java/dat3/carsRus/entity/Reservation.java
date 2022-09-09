package dat3.carsRus.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//-------
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreationTimestamp
    LocalDateTime reservationDate;


    LocalDate rentalDate;

    @ManyToOne
    Member member;

    @ManyToOne
    Car car;

    public Reservation(Member member, Car car, LocalDate rentalDate){
        this.member = member;
        this.car = car;
        this.rentalDate = rentalDate;
    }





}
