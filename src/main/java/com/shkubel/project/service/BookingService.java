package com.shkubel.project.service;

import com.shkubel.project.models.Hotel;
import com.shkubel.project.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    HotelRepository hotelRepository;

    public boolean booking(long id, Hotel hotel) {
        Hotel hotelinDB = hotelRepository.findById(id).get();
        if (hotelinDB.isBook()) {
            return false;
        }
        hotelinDB.setBook(true);
        hotelRepository.save(hotelinDB);

        return true;
    }
}
