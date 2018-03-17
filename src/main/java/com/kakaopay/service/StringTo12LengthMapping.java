package com.kakaopay.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StringTo12LengthMapping {

    private String _trans;
    private String _origin;

    public StringTo12LengthMapping(String trans){

        this._trans = trans;
    }

    public String digest(){return this._trans;}

}

