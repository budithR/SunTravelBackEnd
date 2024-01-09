/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package com.suntravel.contractsmanager.repository;

import com.suntravel.contractsmanager.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 11 Jul 2023
 */
public interface HotelRepo extends JpaRepository <Hotel, Integer>
{
    Optional<Hotel> findHotelByHotelName( String hotelName );
    Optional<Hotel> findHotelByHotelID( int hotelID);
}
