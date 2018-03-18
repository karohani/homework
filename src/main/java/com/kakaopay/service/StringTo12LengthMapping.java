package com.kakaopay.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;


public class StringTo12LengthMapping {

    private String trans;
    private String origin;
    static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();


    public StringTo12LengthMapping(String origin){

        this.origin = origin;
    }


    public BigInteger parseToInteger(String target){

        char[] chars = target.toCharArray();
        BigInteger parsed = new BigInteger("1");
        for(char c : chars){
            System.out.println(chars.toString() + " " + parsed + Character.getNumericValue(c));
            System.out.println("MULTIPLY" + Character.getNumericValue(c));
            parsed = parsed.multiply(BigInteger.valueOf(Character.getNumericValue(c)));
            System.out.println("MULTIPLYED" + parsed.toString());
        }
        return parsed;
    }

    public String digest(){

        final StringBuilder sb = new StringBuilder();
        BigInteger apple = this.parseToInteger(this.origin);
        do{
            int i = apple.mod(BigInteger.valueOf(62)).intValue();
            sb.append(BASE62[i]);
            apple = apple.divide(BigInteger.valueOf(62));
        }while(! apple.equals(BigInteger.ZERO));

        do{
            sb.append("A");
        }while(sb.length() < 16);

        System.out.println(sb.toString());
        return sb.toString().substring(0, 16);
    }

}

