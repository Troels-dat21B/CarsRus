package dat3.carsRus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import dat3.carsRus.entity.Car;
import dat3.carsRus.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
    int id;

    String brand;

    String model;

    int pricePerDay;

    int bestDiscount;
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime created;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss",shape = JsonFormat.Shape.STRING)
    LocalDateTime edited;
    Integer ranking;

    //Convert Car Entity to Car DTO
    public CarResponse(Car c, boolean includeAll) {
        this.id = c.getId();
        this.bestDiscount = c.getBestDiscount();
        this.brand = c.getBrand();
        this.model = c.getModel();
        this.pricePerDay = c.getPricePerDay();
        if(includeAll){
            this.created = c.getCreated();
            this.edited = c.getEdited();
        }
    }
}
