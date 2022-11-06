package com.PP.watchBandStore.security;

public class BandStoreException extends Exception{
    public BandStoreException (ErrMsg errMsg){
        super(errMsg.getMsg());
    }
}
