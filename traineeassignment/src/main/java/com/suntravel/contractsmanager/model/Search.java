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

import java.time.LocalDate;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 20 Jul 2023
 */
public class Search
{
    private int[] roomArray;
    private LocalDate checkingDate;
    private int noOfNights;

    public Search( int[] roomArray, LocalDate checkingDate, int noOfNights )
    {
        this.roomArray = roomArray;
        this.checkingDate = checkingDate;
        this.noOfNights = noOfNights;
    }

    public int[] getRoomArray()
    {
        return roomArray;
    }

    public LocalDate getCheckingDate()
    {
        return checkingDate;
    }

    public int getNoOfNights()
    {
        return noOfNights;
    }

    public void setRoomArray( int[] roomArray )
    {
        this.roomArray = roomArray;
    }

    public void setCheckingDate( LocalDate checkingDate )
    {
        this.checkingDate = checkingDate;
    }

    public void setNoOfNights( int noOfNights )
    {
        this.noOfNights = noOfNights;
    }
}
