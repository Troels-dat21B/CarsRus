package dat3.carsRus.entity;

import dat3.security.entity.Role;
import dat3.security.entity.UserWithRoles;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Member extends UserWithRoles {

    @Column(name = "Fornavn")
    private String firstName;

    @Column(name = "Fornavn")
    private String lastName;

    @Column(name = "Fornavn")
    private int zipCode;

    @Column(name = "Fornavn")
    private String street;

    @Column(name = "Fornavn")
    private String city;

    @Column(name = "Fornavn")
    private boolean isApproved;

    @Column(name = "Fornavn")
    private int ranking;

    @CreationTimestamp
    private LocalDateTime timeCreated;

    @UpdateTimestamp
    private LocalDateTime timeEdited;


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
