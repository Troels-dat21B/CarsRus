package dat3.carsRus.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Member extends UserWithRoles {

    private String firstName;

    private String lastName;

    private String street;

    private String city;

    private String zip;

    private boolean isApproved;

    private Role role;


    public Member(String user, String password, String email, String firstName, String lastName, String street, String city, String zip) {
        super(user, password, email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
    }


}
