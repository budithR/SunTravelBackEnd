/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package com.suntravel.contractsmanager.model;

import java.util.ArrayList;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 26 Jul 2023
 */
public class ContractOut
{
    private String hotelName;
    private int totalPrice;
    private ArrayList<RoomTypeOut> roomTypeOut;

    public ContractOut( String hotelName, int totalPrice, ArrayList<RoomTypeOut> roomTypeOut )
    {
        this.hotelName = hotelName;
        this.totalPrice = totalPrice;
        this.roomTypeOut = roomTypeOut;
    }

    public String getHotelName()
    {
        return hotelName;
    }

    public int getTotalPrice()
    {
        return totalPrice;
    }

    public ArrayList<RoomTypeOut> getRoomTypeOut()
    {
        return roomTypeOut;
    }

    public void setHotelName( String hotelName )
    {
        this.hotelName = hotelName;
    }

    public void setTotalPrice( int totalPrice )
    {
        this.totalPrice = totalPrice;
    }

    public void setRoomTypeOut( ArrayList<RoomTypeOut> roomTypeOut )
    {
        this.roomTypeOut = roomTypeOut;
    }
}
