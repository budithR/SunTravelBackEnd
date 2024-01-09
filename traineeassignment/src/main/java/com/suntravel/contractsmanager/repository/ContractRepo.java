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

import com.suntravel.contractsmanager.model.Contract;
import com.suntravel.contractsmanager.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 11 Jul 2023
 */
public interface ContractRepo extends JpaRepository <Contract, Integer>
{
    List<Contract> findContractsByHotelHotelID(int hotelID);
    Optional<Contract> findContractByContractID( int contractID);
}
