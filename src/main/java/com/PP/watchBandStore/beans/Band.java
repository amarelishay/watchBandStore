package com.PP.watchBandStore.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "bands")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Band {
    @ToString.Exclude
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.DETACH})
    List<User> users;
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String image;
    public int amount;
    private Colors color;
    private double price;
    private double size;
    private double discount;
    private Type type;

}
