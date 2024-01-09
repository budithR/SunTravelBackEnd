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

import com.suntravel.contractsmanager.model.ContractOut;
import com.suntravel.contractsmanager.model.Search;
import com.suntravel.contractsmanager.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 20 Jul 2023
 */
@RestController
@RequestMapping("/search")
public class SearchResource
{
    private final SearchService searchService;

    public SearchResource( SearchService searchService )
    {
        this.searchService = searchService;
    }

    @PostMapping("/get")
    public ArrayList<ContractOut> getSearch( @RequestBody Search search ){

        ArrayList<ContractOut> outPutContractIDList = new ArrayList<>();

        outPutContractIDList = searchService.search( search );
//        int[] outPutArray = new int[outPutContractIDList.size()];
//        for (int i = 0; i < outPutContractIDList.size(); i++) {
//            outPutArray[i] = outPutContractIDList.get(i);
//        }

        return outPutContractIDList;
    }
}
