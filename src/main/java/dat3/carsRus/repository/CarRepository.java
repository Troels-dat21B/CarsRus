package dat3.carsRus.repository;

import dat3.carsRus.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
