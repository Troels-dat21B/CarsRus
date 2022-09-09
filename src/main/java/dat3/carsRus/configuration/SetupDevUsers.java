package dat3.carsRus.configuration;

import dat3.carsRus.entity.Car;
import dat3.carsRus.entity.Member;
import dat3.carsRus.entity.Reservation;
import dat3.carsRus.repository.CarRepository;
import dat3.carsRus.repository.MemberRepository;
import dat3.carsRus.repository.ReservationRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import dat3.security.repository.UserWithRolesRepository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class SetupDevUsers implements ApplicationRunner {

    UserWithRolesRepository userWithRolesRepository;
    String passwordUsedByAll;
    MemberRepository memberRepository;
    CarRepository carRepository;
    ReservationRepository reservationRepository;

    public SetupDevUsers(UserWithRolesRepository userWithRolesRepository, MemberRepository memberRepository, CarRepository carRepository, ReservationRepository reservationRepository) {
        this.userWithRolesRepository = userWithRolesRepository;
        this.memberRepository = memberRepository;
        this.carRepository = carRepository;
        this.reservationRepository = reservationRepository;
        passwordUsedByAll = "test12";
    }

    @Override
    public void run(ApplicationArguments args) {
        //setupUserWithRoleUsers();

        Member member1 = new Member("Trowsel", passwordUsedByAll, "w@e.com", "Troels", "Karn", "Rebæk", "Hvidovre",
                "2650");

        memberRepository.save(member1);

        Car car1 = Car.builder()
                .brand("volvo")
                .model("v70")
                .pricePerDay(700)
                .bestDiscount(50)
                .build();


        carRepository.save(car1);

        Reservation res1 = new Reservation(member1, car1, LocalDate.of(2022,12,24));

        reservationRepository.save(res1);


    }

}
