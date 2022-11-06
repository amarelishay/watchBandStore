package com.PP.watchBandStore.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Watch {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "band_id")
    private Band band;
    private String image;
    private Colors color;
    private double price;

}
