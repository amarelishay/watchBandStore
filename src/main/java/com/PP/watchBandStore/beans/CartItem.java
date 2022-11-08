package com.PP.watchBandStore.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor
public class CartItem {

    private Band band;
    private int amount = 1;

    public CartItem(Band band) {
    }
}
