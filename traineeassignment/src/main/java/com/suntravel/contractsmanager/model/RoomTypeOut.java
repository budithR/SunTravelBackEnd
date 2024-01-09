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

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 26 Jul 2023
 */
public class RoomTypeOut
{
    private String roomTypeName;
    private int price;

    public RoomTypeOut( String roomTypeName, int price )
    {
        this.roomTypeName = roomTypeName;
        this.price = price;
    }

    public String getRoomTypeName()
    {
        return roomTypeName;
    }

    public int getPrice()
    {
        return price;
    }

    public void setRoomTypeName( String roomTypeName )
    {
        this.roomTypeName = roomTypeName;
    }

    public void setPrice( int price )
    {
        this.price = price;
    }
}
