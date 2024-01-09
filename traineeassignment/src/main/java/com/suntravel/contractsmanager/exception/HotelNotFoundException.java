/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package com.suntravel.contractsmanager.exception;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 13 Jul 2023
 */
public class HotelNotFoundException extends RuntimeException
{
    public HotelNotFoundException( String massage )
    {
        super( massage );
    }
}
