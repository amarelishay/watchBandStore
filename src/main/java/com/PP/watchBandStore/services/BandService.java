package com.PP.watchBandStore.services;

import com.PP.watchBandStore.beans.Band;
import com.PP.watchBandStore.beans.CreditCard;
import com.PP.watchBandStore.beans.User;
import com.PP.watchBandStore.security.BandStoreException;

import java.util.List;
import java.util.Set;

public interface BandService {
    List<Band> buy(int userId,List<Band> bands) throws BandStoreException;
    Set<Band> addToCart(int bandId,  User user) throws BandStoreException;

    Set<Band> removeFromCart(Band band, User user) throws BandStoreException;
    Set<Band> getCart(int userId) throws BandStoreException;
    Band addBand(Band band);
    Band findBandById(int id) throws BandStoreException;
    Band findBandByName(String name) throws BandStoreException;
    List<Band> GetAllBands();
}
