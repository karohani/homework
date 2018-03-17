package com.kakaopay.service;

import lombok.Getter;
import lombok.Setter;


public class StringTo12LengthMapping {

    private String _trans;

    public StringTo12LengthMapping(String origin){

        this._trans = origin;
    }

    public String digest(){

        return this._trans;

    }

}

