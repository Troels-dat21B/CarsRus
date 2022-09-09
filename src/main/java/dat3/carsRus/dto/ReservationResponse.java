package dat3.carsRus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.carsRus.entity.Reservation;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReservationResponse {

    int id;
    String memberUsername;
    int carId;
    String carBrand;

    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate rentalDate;

    public ReservationResponse(Reservation reservation) {
        this.id = reservation.getId();
        this.memberUsername = reservation.getMember().getUsername();
        this.carId = reservation.getId();
        this.carBrand = reservation.getCar().getBrand();
    }

}
