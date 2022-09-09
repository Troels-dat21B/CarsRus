package dat3.carsRus.dto;

import dat3.carsRus.entity.Car;
import dat3.carsRus.entity.Member;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CarRequest {

    int id;

    String brand;

    String model;

    int pricePerDay;

    int bestDiscount;


    public static Member getMemberEntity(MemberRequest m) {
        return new Member(m.username, m.getPassword(), m.getEmail(), m.firstName, m.lastName, m.getStreet(), m.getCity(), m.getZip());
    }

    public static Car getCarEntity(CarRequest c) {

      return new Car(c.brand, c.model, c.pricePerDay, c.bestDiscount);
    }

    public CarRequest(Car c) {
      this.id = c.getId();
      this.bestDiscount = c.getBestDiscount();
      this.brand = c.getBrand();
      this.model = c.getModel();
      this.pricePerDay = c.getPricePerDay();
    }


}
