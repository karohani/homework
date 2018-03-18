package com.kakaopay.service;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.Arrays;


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
            parsed = parsed.multiply(BigInteger.valueOf(Character.getNumericValue(c)));
        }
        return parsed;
    }

    public String digest(){

        StringBuilder sb = new StringBuilder();
        BigInteger apple = this.parseToInteger(this.origin);


        do{
            int i = apple.mod(BigInteger.valueOf(62)).intValue();
            sb.append(BASE62[i]);
            apple = apple.divide(BigInteger.valueOf(62));
        }while(! apple.equals(BigInteger.ZERO));


        if(16 - sb.length() > 0){
            char[] ca = new char[16-sb.length()];
            Arrays.fill(ca, 'A');
            sb.append(ca);
        }

//        do{
//            sb.append(BASE62[0]);
//        }while(sb.length() < 16);

        System.out.println(sb.toString());
        return sb.substring(0, 16);
    }

}

