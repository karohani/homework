package com.kakaopay.service;

import lombok.Getter;
import lombok.Setter;


public class StringTo12LengthMapping {

    private String trans;
    private String origin;

    public StringTo12LengthMapping(String origin){

        this.origin = origin;
    }

    public String digest(){

        return this.origin;

    }

}

