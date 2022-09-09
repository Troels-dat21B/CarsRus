package dat3.carsRus.api;

import dat3.carsRus.dto.CarRequest;
import dat3.carsRus.dto.CarResponse;
import dat3.carsRus.entity.Car;
import dat3.carsRus.repository.CarRepository;
import dat3.carsRus.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/cars")
public class CarController {

    CarService carService;
    CarRepository carRepository;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    //Security ADMIN ???
    @GetMapping
    List<CarResponse> getCar() {
        return carService.findCars();
    }


    //Security ADMIN ???
    @GetMapping(path = "/{id}")
    CarResponse getCarById(@PathVariable int id) throws Exception {
        Car found = carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car does not exist"));
        return new CarResponse(found, false);
    }


    //Security --> USER??????
    //@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @PostMapping
    // same as above when you are using @RestController
    CarResponse addCar(@RequestBody CarRequest body) {
        return carService.addCar(body);
    }


    //Security ADMIN/USER ??? ???
    @PutMapping("/{id}")
    ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable int id) {
        //
        return null;
    }


    // Security ADMIN ????
    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable int id) {

    }


}
