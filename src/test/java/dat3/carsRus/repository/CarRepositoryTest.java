package dat3.carsRus.repository;

import dat3.carsRus.entity.Car;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CarRepositoryTest {

    static int carID;


    @Autowired
    CarRepository carRepository;

    @BeforeAll
    public static void setupData(@Autowired CarRepository carRepository){
        Car testCar = new Car("Tesla", "S", 222, 10);

        carRepository.save(testCar);

        carID = testCar.getId();
    }


    @Test
    public void findById(){
        Car found = carRepository.findById(carID).get();
        assertEquals(carID,found.getId());


    }


}