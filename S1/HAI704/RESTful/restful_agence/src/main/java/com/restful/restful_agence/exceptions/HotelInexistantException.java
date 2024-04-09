package com.restful.restful_agence.exceptions;

public class HotelInexistantException extends HotelException{
    public HotelInexistantException(){}

    public HotelInexistantException(String message){
        super(message);
    }

}
