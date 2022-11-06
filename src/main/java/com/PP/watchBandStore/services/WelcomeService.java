package com.PP.watchBandStore.services;


import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.exceptions.SecurityException;

import java.util.UUID;

public interface WelcomeService {
    void register(User user) throws SecurityException, SecurityException;
    UUID login(String email, String password) throws SecurityException;
}
