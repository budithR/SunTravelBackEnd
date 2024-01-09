/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package com.suntravel.contractsmanager.service;

import com.suntravel.contractsmanager.exception.HotelNotFoundException;
import com.suntravel.contractsmanager.model.Contract;
import com.suntravel.contractsmanager.model.Hotel;
import com.suntravel.contractsmanager.repository.HotelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 11 Jul 2023
 */
@Service
public class HotelService
{
    private final HotelRepo hotelRepo;

    @Autowired
    public HotelService( HotelRepo hotelRepo )
    {
        this.hotelRepo = hotelRepo;
    }

    public Hotel addHotel(Hotel hotel)
    {
        return hotelRepo.save( hotel );

    }

    public List<Hotel> findAllHotels()
    {
        return hotelRepo.findAll();
    }
    public Hotel findHotelByHotelName( String hotelName){
        return hotelRepo.findHotelByHotelName(hotelName).orElseThrow(() -> new HotelNotFoundException("Hotel not found for this name - " + hotelName ));
    }
    public Hotel findHotelByHotelID ( int hotelID ){
        return hotelRepo.findHotelByHotelID( hotelID ).orElseThrow(() -> new HotelNotFoundException("Hotel not found for this ID - " + hotelID ));
    }
}
