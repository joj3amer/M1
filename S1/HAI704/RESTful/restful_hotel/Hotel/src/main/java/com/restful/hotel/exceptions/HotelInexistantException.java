package com.restful.hotel.exceptions;

public class HotelInexistantException extends HotelException{
    public HotelInexistantException(){}

    public HotelInexistantException(String message){
        super(message);
    }

}
