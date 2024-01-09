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

import com.suntravel.contractsmanager.model.*;
import com.suntravel.contractsmanager.repository.ContractRepo;
import com.suntravel.contractsmanager.repository.HotelRepo;
import com.suntravel.contractsmanager.repository.RoomTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * <b>Description Title</b>
 * Description Text.
 *
 * @author budith
 * @since 20 Jul 2023
 */
@Service
public class SearchService
{
    private final ContractRepo contractRepo;
    private RoomTypeRepo roomTypeRepo;
    private HotelRepo hotelRepo;


    @Autowired
    public SearchService( ContractRepo contractRepo, RoomTypeRepo roomTypeRepo, HotelRepo hotelRepo )
    {
        this.contractRepo = contractRepo;
        this.roomTypeRepo = roomTypeRepo;
        this.hotelRepo = hotelRepo;
    }

    public ArrayList<ContractOut> search( Search search )
    {

        ArrayList<ArrayList<Integer>> outPutContractIDListAll = new ArrayList<>();
        List<Hotel> outPutAllHotelList = new ArrayList<>();


        outPutAllHotelList = hotelRepo.findAll();
        for( Hotel hotel : outPutAllHotelList ) //Check contracts for each hotel
        {
            ArrayList<Integer> outPutContractIDListSingle = new ArrayList<>();
            int hotelID = hotel.getHotelID();
            List<Contract> contractListGetByHotelID = contractRepo.findContractsByHotelHotelID( hotelID );
            List<Contract> contractListAvailableForCheckingDateAndNoOfNights = new ArrayList<>();
            for( Contract contract : contractListGetByHotelID )
            {
                if( search.getCheckingDate().isAfter( contract.getStartDate() ) && search.getCheckingDate().isBefore( contract.getEndDate() ) )
                {
                    if( search.getCheckingDate().plusDays( search.getNoOfNights() ).isBefore( contract.getEndDate() ) ) //After sorted by date and noOfNights
                    {
                        contractListAvailableForCheckingDateAndNoOfNights.add( contract );

                    }
                }
            }
            //Sorting max adults start
            if( findMinNumber( search.getRoomArray()  ) != -1){
                int lowestNumberOfMaxAdultsNeeds = findMinNumber( search.getRoomArray() );
                List<Contract> contractListRemovedLowerMaxAdult = new ArrayList<>();
                for (Contract contractCheckMaxAdults : contractListAvailableForCheckingDateAndNoOfNights){
                    if (contractCheckMaxAdults.getRoomType().getMaxAdults()>=lowestNumberOfMaxAdultsNeeds){
                        contractListRemovedLowerMaxAdult.add( contractCheckMaxAdults );
                        //Sorting max adults end
                    }
                }
                //Creating two arrays for store room data Start
                List<Integer> availableMaxAdultList = new ArrayList<>();
                List<Integer> availableNoOfRoomList = new ArrayList<>();   //These two arrays same size

                for( Contract contractCreate2Arrays : contractListRemovedLowerMaxAdult){
                    availableMaxAdultList.add( contractCreate2Arrays.getRoomType().getMaxAdults() );
                    availableNoOfRoomList.add( contractCreate2Arrays.getRoomType().getNoOfRooms() );
                    //Creating two arrays for store room data End

                }
                //Creating available max adult list without high values start
                List<Integer> selectedMaxAdultValue = new ArrayList<>();
                for (int frontEndInputAdultValue : search.getRoomArray()){
                    List<Integer> allAvailableHighAdultRooms = new ArrayList<>();
                    for (int twoArraysAdult : availableMaxAdultList){
                        if (twoArraysAdult>=frontEndInputAdultValue){
                            allAvailableHighAdultRooms.add( twoArraysAdult );
//                        System.out.println(allAvailableHighAdultRooms);
                        }
                    }
                    //add minimum adult
                    if( findMinNumberList( allAvailableHighAdultRooms ) != -1 ) {
                        selectedMaxAdultValue.add( findMinNumberList( allAvailableHighAdultRooms ));
                    }


                    //decrease room availability

                    if( findMinNumberList( allAvailableHighAdultRooms ) != -1 ) {
                        int indexToBeChanged = availableMaxAdultList.indexOf( findMinNumberList( allAvailableHighAdultRooms ) ); //find the index of max adult 2 array
                        System.out.println(availableNoOfRoomList);
                        availableNoOfRoomList.set(indexToBeChanged, (availableNoOfRoomList.get( indexToBeChanged ) - 1)); //Decrease by one
                        System.out.println(availableNoOfRoomList);
                        System.out.println(selectedMaxAdultValue);
                    }



                }
                //looping contract for find contract ids of selected noOfRooms
                for (int maxAdultNumber : selectedMaxAdultValue ){
                    for (Contract contractToGetID : contractListRemovedLowerMaxAdult ){
                        if(maxAdultNumber == contractToGetID.getRoomType().getMaxAdults()){
                            outPutContractIDListSingle.add( contractToGetID.getContractID() );
                            break;
                        }
                    }
                }
                System.out.println(outPutContractIDListSingle);

                //Check if the remaining rooms are negative. if not add these contracts to output array
                int negativeRoomChecker = 1;
                for( int checkRoomNumberNegative : availableNoOfRoomList ){
                    if( checkRoomNumberNegative <0 ){
                        negativeRoomChecker = 0;
                    }
                }
//              Adding hotel id
                if( negativeRoomChecker == 1 && outPutContractIDListSingle != null && outPutContractIDListSingle.size()>0 ){
                    outPutContractIDListSingle.add( hotelID );
                }
                System.out.println(outPutContractIDListSingle);
                if (outPutContractIDListSingle.size()>0 && outPutContractIDListSingle.size()>search.getRoomArray().length){
                    outPutContractIDListAll.add( outPutContractIDListSingle );
                    System.out.println( outPutContractIDListAll );
                }

            }


        }
        ArrayList<ContractOut> contractOutArrayList = new ArrayList<>();
        Optional<Hotel> hotelTemp;
        ContractOut contractOutTemp;

        Optional<Contract> contractTemp;
        RoomTypeOut roomTypeOut;
        int totalPrice;
        if( outPutContractIDListAll.isEmpty() ){
            System.out.println("null array");
            return new ArrayList<>();

        }
        else {
            System.out.println(outPutContractIDListAll + "test");
            for(ArrayList<Integer> singleContract: outPutContractIDListAll ){
                totalPrice = 0;
                ArrayList<RoomTypeOut> roomTypeOutArrayList = new ArrayList<>();
                for (int i = 0; i<singleContract.size()-1; i++){
                    contractTemp =  contractRepo.findContractByContractID( singleContract.get( i ) );
                    roomTypeOut = new RoomTypeOut(contractTemp.get().getRoomType().getRoomTypeName(), contractTemp.get().getRoomType().getPricePerPerson());
                    roomTypeOutArrayList.add( roomTypeOut );
                    System.out.println(roomTypeOutArrayList.size());


                }
                for (int j = 0; j < roomTypeOutArrayList.size(); j++){
                    totalPrice = totalPrice + roomTypeOutArrayList.get( j ).getPrice()*search.getNoOfNights()*search.getRoomArray()[j] ;
                    System.out.println(totalPrice);
                }
                hotelTemp = hotelRepo.findHotelByHotelID( singleContract.get( singleContract.size() -1 ) );
                System.out.println(totalPrice);
                totalPrice = (totalPrice*115)/100;
                contractOutTemp = new  ContractOut( hotelTemp.get().getHotelName() ,  totalPrice , roomTypeOutArrayList);
                contractOutArrayList.add( contractOutTemp );

            }
            System.out.println(contractOutArrayList.get( 0 ).getTotalPrice());
            System.out.println(contractOutArrayList);
            return contractOutArrayList;

        }




    }

    public static int findMinNumber(int[] arr) {
        int min = -1;
        if (arr != null && arr.length > 0) {

            min = arr[0]; // Assume the first element is the minimum

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] < min) {
                    min = arr[i]; // Update the minimum if a smaller element is found
                }
            }
        }



        return min;
    }
    public static int findMinNumberList(List<Integer> list) {
        int min = -1;
        if (list != null && list.size()>0) {
//            throw new IllegalArgumentException("List is empty or null");
            min = list.get(0); // Assume the first element is the minimum

            for (int i = 1; i < list.size(); i++) {
                int currentNumber = list.get(i);
                if (currentNumber < min) {
                    min = currentNumber; // Update the minimum if a smaller element is found
                }
            }
        }



        return min;
    }

}
