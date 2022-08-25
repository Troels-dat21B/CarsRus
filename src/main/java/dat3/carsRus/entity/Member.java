package dat3.carsRus.entity;

import dat3.security.entity.UserWithRoles;
import javax.persistence.Entity;

@Entity
public class Member extends UserWithRoles {

    private String firstName;

    private String lastName;

    private String street;

    private String city;

    private int zipCode;

    private boolean isApproved;

    private int ranking;

    public Member(){}

    public Member(String user, String password, String email, String firstName, String lastName, String street,
                  String city, int zipCode, boolean isApproved, int ranking){
        super(user, password, email);
        this.city = city;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isApproved = isApproved;
        this.street = street;
        this.zipCode = zipCode;
        this.ranking = ranking;

    }

}
