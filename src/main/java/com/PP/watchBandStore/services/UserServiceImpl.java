package com.PP.watchBandStore.services;

import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.repository.UserRepository;
import com.PP.watchBandStore.security.BandStoreException;
import com.PP.watchBandStore.security.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    @Override
    public void updateUser(User user) throws BandStoreException {
        userRepository.saveAndFlush(userRepository.findById(user.getId()).
                orElseThrow(()->new BandStoreException
                        (ErrMsg.DontExistException)));
    }

    @Override
    public User addUser(User user) throws BandStoreException {
        if(userRepository.existsById(user.getId())){
            throw new BandStoreException(ErrMsg.COUPON_ALREADY_EXIST);
        }
        return userRepository.save(user);
    }


}
