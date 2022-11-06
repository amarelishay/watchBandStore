package com.PP.watchBandStore.security;

import com.PP.watchBandStore.exceptions.SecMsg;
import com.PP.watchBandStore.exceptions.SecurityException;
import com.PP.watchBandStore.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TokenManager {
    private final UserRepository userRepository;
    private final Map<UUID, Information> map;


    public UUID add(String email, String password)  {
        Information information = new Information();
        information.setEmail(email);
        information.setUserId(userRepository.findByEmail(email).getId());
        information.setTime(LocalDateTime.now());

        UUID token = UUID.randomUUID();
        map.put(token, information);
        return token;
    }

    public int getUserId(UUID token) throws SecurityException {

        Information information = map.get(token);
        if (information == null) {
            throw new SecurityException(SecMsg.INVALID_TOKEN);
        }
        return information.getUserId();
    }


}
