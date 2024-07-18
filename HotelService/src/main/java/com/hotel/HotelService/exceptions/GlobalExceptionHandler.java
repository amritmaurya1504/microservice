package com.hotel.HotelService.exceptions;

import com.hotel.HotelService.exceptions.ResourceNotFound;
import com.hotel.HotelService.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFound ex){
        String msg = ex.getMessage();
        ApiResponse response = ApiResponse
                .builder()
                .message(msg)
                .success(true).status(HttpStatus.NOT_FOUND).build();

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
