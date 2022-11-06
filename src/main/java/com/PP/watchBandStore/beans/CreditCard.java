package com.PP.watchBandStore.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreditCard {
    @Id
    @GeneratedValue
    private int id;
    private String fullName;
    private long cardNum;
    private int cvc;
    private Date exDate;


}
