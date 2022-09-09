package dat3.carsRus.service;

import dat3.carsRus.dto.CarRequest;
import dat3.carsRus.dto.CarResponse;
import dat3.carsRus.entity.Car;
import dat3.carsRus.repository.CarRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<CarResponse> findCars() {
        List<Car> cars = carRepository.findAll();
        List<CarResponse> response = cars.stream().map(car -> new CarResponse(car, false)).collect(Collectors.toList());

        return response;

    }

    public CarResponse addCar(CarRequest carRequest) {


        if (carRepository.existsById(carRequest.getId()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Member with this ID already exist");


        Car newCar = CarRequest.getCarEntity(carRequest);
        newCar = carRepository.save(newCar);

        return new CarResponse(newCar, false);
    }

    //fINDcARbYiD
    public CarResponse findCarById(int id){
        Car found = carRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Car not found"));
        return new CarResponse(found,false);
    }

    public void editcar(CarRequest body, int id) {

        Car car = carRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Car already exixt"));

        car.setBestDiscount(body.getBestDiscount());
        car.setPricePerDay(body.getPricePerDay());

        carRepository.save(car);

    }
}
