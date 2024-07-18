package com.hotel.HotelService.exceptions;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound() {
        super("Resource Not Found!");
    }

    public ResourceNotFound(String message) {
        super(message);
    }
}
