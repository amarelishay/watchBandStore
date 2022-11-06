package com.PP.watchBandStore.controllers;

import com.PP.watchBandStore.beans.Band;
import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.exceptions.SecurityException;
import com.PP.watchBandStore.repository.UserRepository;
import com.PP.watchBandStore.security.BandStoreException;
import com.PP.watchBandStore.security.TokenManager;
import com.PP.watchBandStore.services.BandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("api/band")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BandController {
    private final TokenManager tokenManager;
    private final UserRepository userRepository;
    private final BandService bandService;

    @PostMapping("/buy")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Band> buyBands(@RequestHeader("Authorization") UUID token) throws SecurityException, BandStoreException {
        int userId = tokenManager.getUserId(token);
        User user = userRepository.getById(userId);
        return bandService.buy(userId, (List<Band>) user.getCart());
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Set<Band> addToCart(@RequestHeader("Authorization") UUID token,@RequestParam int id) throws SecurityException, BandStoreException {
        int userId = tokenManager.getUserId(token);
       return bandService.addToCart(id, userRepository.getById(userId));
    }
    @DeleteMapping("/remove")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Set<Band> removeFromCart(@RequestHeader("Authorization") UUID token,@RequestParam int id) throws SecurityException, BandStoreException {
        int userId = tokenManager.getUserId(token);
        return bandService.removeFromCart(bandService.findBandById(id), userRepository.getById(userId));
    }
    @GetMapping("/bands")
    public List<Band> getAllBands() throws SecurityException {
        return bandService.GetAllBands();
    }
    @GetMapping ("/{id}")
    public Band getBandById(@PathVariable int id) throws BandStoreException, SecurityException {
//        int userId = tokenManager.getUserId(token);
        return bandService.findBandById(id);
    }
    @GetMapping("/cart")
    public Set<Band> getUserCart(@RequestHeader("Authorization") UUID token) throws SecurityException, BandStoreException {
        Set<Band> bands=bandService.getCart(tokenManager.getUserId(token));
        return bands;
    }
    @GetMapping("/by_name/{name}")
    public Band getBandByName(@RequestHeader("Authorization") UUID token,@PathVariable String name) throws BandStoreException, SecurityException {
        int userId = tokenManager.getUserId(token);
        return bandService.findBandByName(name);
    }



}
