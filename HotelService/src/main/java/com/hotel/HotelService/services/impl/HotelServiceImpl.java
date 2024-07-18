package com.hotel.HotelService.services.impl;

import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.exceptions.ResourceNotFound;
import com.hotel.HotelService.repositories.HotelRepo;
import com.hotel.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setHotelId(hotelId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return this.hotelRepo.findAll();
    }

    @Override
    public Hotel get(String hotelId) {
        return this.hotelRepo.findById(hotelId).orElseThrow(() -> new
                ResourceNotFound("Hotel with given id not found " + hotelId));
    }
}
