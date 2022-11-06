package com.PP.watchBandStore.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private int userId;
    private LocalDateTime time;
    private String email;
}
