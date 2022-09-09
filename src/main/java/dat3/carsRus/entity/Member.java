package dat3.carsRus.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member extends UserWithRoles {

    private String firstName;

    private String lastName;

    private String street;

    private String city;

    private String zip;

    private boolean isApproved;

    private Role role;

    private int ranking;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservation(Reservation reservation){
        reservations.add(reservation);
        reservation.setMember(this);
    }

    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }


}
