package dat3.carsRus.api;

import dat3.carsRus.dto.CarRequest;
import dat3.carsRus.dto.CarResponse;
import dat3.carsRus.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("api/cars")
    public class CarController {

        CarService carService;

        public CarController(CarService carService) {
            this.carService = carService;
        }

        //Security ADMIN
        @GetMapping
        List<CarResponse> getCars(){
            return carService.getCars();
        }

        //Security ADMIN
        @GetMapping(path = "/{id}")
        CarResponse getCarById(@PathVariable int id) throws Exception {
            return carService.findCarById(id);
        }

        @PostMapping
        CarResponse addCar(@RequestBody CarRequest body){
            CarResponse res = carService.addCar(body);
            return res;
        }

        //Security USER/ADMIN
        @PutMapping("/{id}")
        ResponseEntity<Boolean> editCar(@RequestBody CarRequest body, @PathVariable int id){
            carService.editCar(body,id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }

        // Security ADMIN
        @DeleteMapping("/{id}")
        void deleteCarById(@PathVariable int id) {
            //TODO Denne sletter ikke bilen
            carService.deleteById(id);
        }

}
