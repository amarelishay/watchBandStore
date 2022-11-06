package com.PP.watchBandStore.services;

import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.exceptions.SecMsg;
import com.PP.watchBandStore.exceptions.SecurityException;
import com.PP.watchBandStore.repository.UserRepository;
import com.PP.watchBandStore.security.TokenManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WelcomeServiceImpl implements WelcomeService {
    private final UserRepository userRepository;
    private final TokenManager tokenManager;

    @Override
    public void register(User user) throws SecurityException {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new SecurityException(SecMsg.EMAIL_ALREADY_EXIST);

        }
        userRepository.save(user);
    }

    @Override
    public UUID login(String email, String password) throws SecurityException {
       if(!userRepository.existsByEmailAndPassword(email, password)){
           throw new SecurityException(SecMsg.EMAIL_OR_PASSWORD_INCORRECT);
       }
        UUID token = tokenManager.add(email, password);
        return token;
    }
}
