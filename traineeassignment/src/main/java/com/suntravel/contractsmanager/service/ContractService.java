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

import com.suntravel.contractsmanager.exception.HotelNotFoundException;
import com.suntravel.contractsmanager.model.Contract;
import com.suntravel.contractsmanager.model.Hotel;
import com.suntravel.contractsmanager.repository.ContractRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 11 Jul 2023
 */
@Service
public class ContractService
{
    private final ContractRepo contractRepo;

    @Autowired
    public ContractService( ContractRepo contractRepo )
    {
        this.contractRepo = contractRepo;
    }

    public Contract addContract( Contract contract )
    {
        return contractRepo.save( contract );
    }

    public List<Contract> findAllContracts()
    {
        return contractRepo.findAll();
    }


    public Contract findContractByContractID ( int contractID ){
        return contractRepo.findContractByContractID( contractID ).orElseThrow(() -> new HotelNotFoundException("Contract not found for this ID - " + contractID ));
    }
    public List<Contract> findContractsByHotelID( int hotelID){
        List<Contract> contracts = new ArrayList<>();
        for (Contract contract : findAllContracts()) {
            if( contract.getHotel().getHotelID() == hotelID) {
                contracts.add( contract );
            }
        } return contracts;
    }
    public List<Contract> findContractByRoomTypeId( int roomTypeID) {
        List<Contract> contracts = new ArrayList<>();
        for (Contract contract : findAllContracts())
        {
            if( Objects.equals( contract.getRoomType().getRoomTypeID(), roomTypeID ) )
            {
                contracts.add( contract );
            }
        }return contracts;
    }


}
