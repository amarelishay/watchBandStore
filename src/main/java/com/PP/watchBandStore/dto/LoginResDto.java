package com.PP.watchBandStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * Created by kobis on 19 May, 2022
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class LoginResDto {


    private String email;
    private UUID token;


}
