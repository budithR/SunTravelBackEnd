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

import jakarta.persistence.*;
import lombok.Data;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 11 Jul 2023
 */
@Entity
@Table(name = "room_type")
@Data
public class RoomType
{
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( nullable = false, updatable = false )
    private int roomTypeID;
    private String roomTypeName;
    private int maxAdults;
    private int noOfRooms;
    private int pricePerPerson;

//    @OneToOne(mappedBy = "roomType")
//    private Contract contract;

    @ManyToOne
    @JoinColumn(name = "hotelID", nullable = false)
    private Hotel hotel;
}
