package dat3.carsRus.configuration;

import dat3.carsRus.entity.Car;
import dat3.carsRus.repository.CarRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class setUpCar implements ApplicationRunner {

    CarRepository carRepository;

    public void setUpCar(CarRepository carRepository){
        this.carRepository = carRepository;

    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Car car1 = new Car("Tesla", "S", 200, 10);

        carRepository.save(car1);


    }
}

