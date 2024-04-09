package com.restful.restful_agence.exceptions;

public class HotelException extends Exception{
    public HotelException(){

    }

    public HotelException(String message){
        //Appel de la methode mere;
        super(message);
    }
}
