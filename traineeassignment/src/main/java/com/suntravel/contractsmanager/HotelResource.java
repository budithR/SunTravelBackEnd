/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package com.suntravel.contractsmanager;

import com.suntravel.contractsmanager.model.Contract;
import com.suntravel.contractsmanager.model.Hotel;
import com.suntravel.contractsmanager.service.HotelService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 13 Jul 2023
 */
@RestController
@RequestMapping( "/hotel" )
public class HotelResource
{
    private final HotelService hotelService;

    public HotelResource( HotelService hotelService )
    {
        this.hotelService = hotelService;
    }

    @GetMapping( "/all" )
    public ResponseEntity<List<Hotel>> getAllHotels()
    {
        List<Hotel> hotels = hotelService.findAllHotels();
        return new ResponseEntity<>( hotels, HttpStatus.OK );
    }

    @GetMapping( "/findHotelByHotelName/{hotelName}" )
    public ResponseEntity<Hotel> getHotelByHotelName( @PathVariable( "hotelName" ) String hotelName )
    {
        Hotel hotel = hotelService.findHotelByHotelName( hotelName );
        return new ResponseEntity<>( hotel, HttpStatus.OK );
    }

    @PostMapping( "/add" )
    public ResponseEntity<Hotel> addHotel( @RequestBody Hotel hotel )
    {
        Hotel newHotel = hotelService.addHotel( hotel );
        return new ResponseEntity<>( newHotel, HttpStatus.CREATED );
    }

    @GetMapping( "/findHotelByHotelID/{hotelID}" )
    public ResponseEntity<Hotel> getHotelByHotelID( @PathVariable( "hotelID" ) int hotelID )
    {
        Hotel hotel = hotelService.findHotelByHotelID( hotelID );
        return new ResponseEntity<>( hotel, HttpStatus.OK );
    }
}
