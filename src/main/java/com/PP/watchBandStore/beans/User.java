package com.PP.watchBandStore.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "users")
    private List<Band> bands;

    @JsonIgnore
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "users")
    private Set<Band> cart=new HashSet<>();

}
