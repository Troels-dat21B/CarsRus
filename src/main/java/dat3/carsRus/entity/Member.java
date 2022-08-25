package dat3.carsRus.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;

import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Member extends UserWithRoles {

    private String firstName;

    private String lastName;

    private int zipCode;

    private String street;

    private String city;

    private boolean isApproved;

    private int ranking;

    public Member(String username, String email,
                  String password, boolean enabled,
                  LocalDateTime created, LocalDateTime edited,
                  List<Role> roles, String firstName, String lastName,
                  int zipCode, String street, String city,
                  boolean isApproved, int ranking) {
        super(username, email, password, enabled, created, edited, roles);
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipCode = zipCode;
        this.street = street;
        this.city = city;
        this.isApproved = isApproved;
        this.ranking = ranking;
    }

    public Member(){}

}
