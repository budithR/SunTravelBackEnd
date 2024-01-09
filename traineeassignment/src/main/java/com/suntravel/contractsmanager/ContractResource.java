/*
 * Copyright (c) 2023. CodeGen International (Pvt) Ltd. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of CodeGen
 * International (Pvt) Ltd. ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with CodeGen International.
 *
 */
package com.suntravel.contractsmanager;

import com.suntravel.contractsmanager.model.Contract;
import com.suntravel.contractsmanager.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 12 Jul 2023
 */
@RestController
@RequestMapping( "/contract" )
public class ContractResource
{
    private final ContractService contractService;

    public ContractResource( ContractService contractService )
    {
        this.contractService = contractService;
    }

    @GetMapping( "/all" )
    public ResponseEntity<List<Contract>> getAllContracts()
    {
        List<Contract> contracts = contractService.findAllContracts();
        return new ResponseEntity<>( contracts, HttpStatus.OK );
    }

    @GetMapping( "/findByHotelID/{hotelID}" )
    public ResponseEntity<List<Contract>> getAllContractsByHotelId( @PathVariable( "hotelID" ) int hotelID )
    {
        List<Contract> contracts = contractService.findContractsByHotelID( hotelID );
        return new ResponseEntity<>( contracts, HttpStatus.OK );
    }
    @GetMapping("/findContractByContractID/{contractID}")
    public ResponseEntity<Contract> getContractByContractID ( @PathVariable("contractID") int contractID){
        Contract contract = contractService.findContractByContractID( contractID );
        return new ResponseEntity<>( contract, HttpStatus.OK );
    }

    @GetMapping( "/findByRoomTypeID/{roomTypeID}" )
    public ResponseEntity<List<Contract>> getAllContractsByRoomTypeID( @PathVariable( "roomTypeID" ) int roomTypeID )
    {
        List<Contract> contracts = contractService.findContractByRoomTypeId( roomTypeID );
        return new ResponseEntity<>( contracts, HttpStatus.OK );
    }

    @PostMapping( "/add" )
    public ResponseEntity<Contract> addContract( @RequestBody Contract contract )
    {
        Contract newContract = contractService.addContract( contract );
        return new ResponseEntity<>( newContract, HttpStatus.CREATED );
    }
}
