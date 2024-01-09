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
import com.suntravel.contractsmanager.model.RoomType;
import com.suntravel.contractsmanager.service.RoomTypeService;
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
@RequestMapping("/roomtype")
public class RoomTypeResource
{
    private final RoomTypeService roomTypeService;

    public RoomTypeResource( RoomTypeService roomTypeService )
    {
        this.roomTypeService = roomTypeService;
    }
    @PostMapping( "/add" )
    public ResponseEntity<RoomType> addRoomType( @RequestBody RoomType roomType )
    {
        RoomType newRoomType = roomTypeService.addRoomType( roomType );
        return new ResponseEntity<>( newRoomType, HttpStatus.CREATED );
    }
    @GetMapping( "/all" )
    public ResponseEntity<List<RoomType>> getAllRoomTypes()
    {
        List<RoomType> roomTypes = roomTypeService.findAllRoomTypes();
        return new ResponseEntity<>( roomTypes, HttpStatus.OK );
    }
    @GetMapping( "/findByMaxAdults/{maxAdults}" )
    public ResponseEntity<List<RoomType>> getAllRoomTypesByMaxAdults( @PathVariable( "maxAdults" ) int maxAdults )
    {
        List<RoomType> roomTypes = roomTypeService.findRoomTypeByMaxAdults( maxAdults );
        return new ResponseEntity<>( roomTypes, HttpStatus.OK );
    }

    @GetMapping( "/findByRoomTypeID/{roomTypeID}" )
    public ResponseEntity<RoomType> getAllRoomTypesByRoomTypeID( @PathVariable( "roomTypeID" ) int roomTypeID )
    {
        RoomType roomType = roomTypeService.findRoomTypeByRoomTypeID( roomTypeID );
        return new ResponseEntity<>( roomType, HttpStatus.OK );
    }
}
