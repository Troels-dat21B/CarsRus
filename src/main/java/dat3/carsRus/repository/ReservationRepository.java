package dat3.carsRus.repository;

import dat3.carsRus.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    boolean existsByCar_IdAndRentalDate(int carId, LocalDate date);

}
