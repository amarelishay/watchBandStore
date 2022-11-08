package com.PP.watchBandStore.beans;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int phoneNumber;
    private int countryCode;
    @Email
    private String email;
    private String Country;
    private int zipCode;
    private String address;
    private String password;
    private List<Band> bands;

    private List<CartItem>cartItems=new ArrayList<>();

}
