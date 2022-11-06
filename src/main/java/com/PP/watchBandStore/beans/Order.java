package com.PP.watchBandStore.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private List<Band> bands;
    private double shippingPrice;
    private double fullPrice;
}
