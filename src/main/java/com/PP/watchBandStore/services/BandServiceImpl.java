package com.PP.watchBandStore.services;

import com.PP.watchBandStore.beans.Band;
import com.PP.watchBandStore.beans.CartItem;
import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.repository.BandRepository;
import com.PP.watchBandStore.repository.UserRepository;
import com.PP.watchBandStore.security.BandStoreException;
import com.PP.watchBandStore.security.ErrMsg;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BandServiceImpl implements BandService {
    private final BandRepository bandRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public List<Band> buy(int userId) throws BandStoreException {
        User user = userRepository.findById(userId).orElseThrow(() -> new BandStoreException(ErrMsg.DontExistException));
        List<CartItem> cartItems=user.getCartItems();
        List<Band> bands=new ArrayList<>();
        for (CartItem cartItem :cartItems){
            bands.add(cartItem.getBand());
        }
        List<Band> userBands=user.getBands();
        for (Band band:bands) {
            userBands.add(band);
        }
        user.setBands(userBands);
        userService.updateUser(user);
        return bands;
    }

    @Override
    public List<CartItem> addToCart(int bandId, User user) throws BandStoreException {
        Band band = bandRepository.findById(bandId).orElseThrow(() -> new BandStoreException(ErrMsg.DontExistException));
        for (CartItem cartItem1 : user.getCartItems()) {
            if (cartItem1.getBand().getId() == bandId) {
                if (cartItem1.getAmount() > band.getAmount()) {
                    throw new BandStoreException(ErrMsg.DontExistException);
                }
                cartItem1.setAmount(cartItem1.getAmount() + 1);
                return user.getCartItems();
            }

        }
        user.getCartItems().add(new CartItem(band));
        return user.getCartItems();

    }


    public List<CartItem> removeFromCart(int bandId, User user) throws BandStoreException {
        Band band = bandRepository.findById(bandId).orElseThrow(() -> new BandStoreException(ErrMsg.DontExistException));
        for (CartItem cartItem1 : user.getCartItems()) {
            if (cartItem1.getBand().getId() == bandId) {
                if (cartItem1.getAmount() ==0) {
                    throw new BandStoreException(ErrMsg.DontExistException);
                }
                cartItem1.setAmount(cartItem1.getAmount() - 1);
                return user.getCartItems();
            }

        }
        user.getCartItems().add(new CartItem(band));
        return user.getCartItems();

    }

    @Override
    public List<CartItem> getCart(int userId) throws BandStoreException {
        if (!userRepository.existsById(userId)) {
            throw new BandStoreException(ErrMsg.DontExistException);
        }
        return userRepository.getById(userId).getCartItems();
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
