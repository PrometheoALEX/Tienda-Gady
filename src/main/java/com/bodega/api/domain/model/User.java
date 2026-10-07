package com.bodega.api.domain.model;

import com.bodega.api.domain.exceptions.DomainRuleException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;
    private Role role;
    private String firstName;
    private String lastName;
    private String dni;
    private String phone;
    private String email;
    private String password;
    private Boolean active;
    private LocalDateTime registrationDate;

    public static User create(Role role, String firstName, String lastName, String dni, String email, String password) {
        if (dni == null || dni.isEmpty() || dni.length() != 8) {
            throw new DomainRuleException("DNI is required and must contain exactly 8 digits");
        }
        if (email == null || email.isEmpty() || !email.contains("@")) {
            throw new DomainRuleException("Email address is invalid");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new DomainRuleException("First name is required");
        }

        User user = new User();
        user.setRole(role);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDni(dni);
        user.setEmail(email);
        user.setPassword(password);
        user.setActive(true);
        user.setRegistrationDate(LocalDateTime.now());

        return user;
    }
}