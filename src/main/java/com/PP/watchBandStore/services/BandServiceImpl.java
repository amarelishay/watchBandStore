package com.PP.watchBandStore.services;

import com.PP.watchBandStore.beans.Band;
import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.repository.BandRepository;
import com.PP.watchBandStore.repository.UserRepository;
import com.PP.watchBandStore.security.BandStoreException;
import com.PP.watchBandStore.security.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BandServiceImpl implements BandService {
    private final BandRepository bandRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public List<Band> buy(int userId, List<Band> bands) throws BandStoreException {
        User user = userRepository.findById(userId).orElseThrow(() -> new BandStoreException(ErrMsg.DontExistException));
        user.getBands().addAll(bands);
        userService.updateUser(user);
        return bands;
    }

    @Override
    public Set<Band> addToCart(int bandId, User user) throws BandStoreException {
        if (user.getCart() == null) {
            user.setCart(new HashSet<>());
        }
        Set<Band> cart = user.getCart();
        Band band=bandRepository.findById(bandId).orElseThrow(()->new BandStoreException(ErrMsg.DontExistException));
        cart.add(band);
        user.setCart(cart);
        if (band.getUsers()==null){
            band.setUsers(new ArrayList<User>());
        }
        band.getUsers().add(user);
        bandRepository.saveAndFlush(band);
        userService.updateUser(user);
        return user.getCart();
    }

    @Override
    public Set<Band> removeFromCart(Band band, User user) throws BandStoreException {
        if (!user.getCart().remove(band)) {
            throw new BandStoreException(ErrMsg.DontExistException);
        }
        userService.updateUser(user);
        return user.getCart();
    }

    @Override
    public Set<Band> getCart(int userId) throws BandStoreException {
        if (!userRepository.existsById(userId)) {
            throw new BandStoreException(ErrMsg.DontExistException);
        }
        return userRepository.getById(userId).getCart();
    }

    @Override
    public Band addBand(Band band) {
        bandRepository.save(band);
        return band;
    }

    @Override
    public Band findBandById(int id) throws BandStoreException {
        return bandRepository.findById(id).orElseThrow(() -> new BandStoreException(ErrMsg.DontExistException));
    }

    @Override
    public Band findBandByName(String name) throws BandStoreException {
        if (bandRepository.findByName(name) == null) {
            throw new BandStoreException(ErrMsg.DontExistException);
        }
        return bandRepository.findByName(name);
    }

    @Override
    public List<Band> GetAllBands() {
        return bandRepository.findAll();
    }
}
