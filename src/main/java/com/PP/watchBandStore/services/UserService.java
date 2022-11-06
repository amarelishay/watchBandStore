package com.PP.watchBandStore.services;

import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.security.BandStoreException;

public interface UserService {

    void updateUser(User user) throws BandStoreException;
    User addUser(User user) throws BandStoreException;
}
