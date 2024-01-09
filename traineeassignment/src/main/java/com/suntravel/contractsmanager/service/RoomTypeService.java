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

import com.suntravel.contractsmanager.exception.RoomTypeNotFoundException;
import com.suntravel.contractsmanager.model.Hotel;
import com.suntravel.contractsmanager.model.RoomType;
import com.suntravel.contractsmanager.repository.RoomTypeRepo;
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
public class RoomTypeService
{
    private final RoomTypeRepo roomTypeRepo;

    @Autowired
    public RoomTypeService( RoomTypeRepo roomTypeRepo )
    {
        this.roomTypeRepo = roomTypeRepo;
    }

    public RoomType addRoomType( RoomType roomType){
        return roomTypeRepo.save(roomType);
    }

    public List<RoomType> findAllRoomTypes()
    {
        return roomTypeRepo.findAll();
    }

    public List<RoomType> findRoomTypeByMaxAdults( int maxAdults)
    {
        return roomTypeRepo.findRoomTypeByMaxAdults(maxAdults);
    }
    public RoomType findRoomTypeByRoomTypeID( int roomTypeID )
    {
        return roomTypeRepo.findRoomTypeByRoomTypeID(roomTypeID).orElseThrow(() -> new RoomTypeNotFoundException("Room type not found for " + roomTypeID + "ID") );
    }


}
