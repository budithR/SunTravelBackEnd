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

import java.io.Serializable;
import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 10 Jul 2023
 */
@Entity
@Table(name = "hotel")
@Data
public class Hotel implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private int hotelID;
    private String hotelName;

//    @OneToMany(mappedBy = "hotel")
//    private List<RoomType> roomTypes;
//
//    @OneToMany(mappedBy = "hotel")
//    private List<Contract> contracts;
}
