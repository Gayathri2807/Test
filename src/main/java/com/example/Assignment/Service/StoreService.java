package com.example.Assignment.Service;

import com.example.Assignment.Model.StoreAvailability;
import com.example.Assignment.Model.StoreCapacity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class StoreService implements StoreList {

    private static List<StoreAvailability> storeAvailabilityList = new ArrayList<>();
    private static List<StoreCapacity> storeCapacityList = new ArrayList<>();

    /***
     * setting the availability list
     */
    @Async
    public void getAvailabilityList(){
        storeAvailabilityList.add(new StoreAvailability("Store001", "Prod1", "2021-02-19", 0));
        storeAvailabilityList.add(new StoreAvailability("Store001", "Prod2", "2021-02-20", 3.0));
        storeAvailabilityList.add(new StoreAvailability("Store001", "Prod2", "2021-02-21",0));
    }

    /***
     * setting the capacity list
     */
    public void getCapacityList()  {
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-19", 0));
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-20", 2.0));
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-21", 2.0));
        storeCapacityList.add(new StoreCapacity("Store001", "Prod1", "2021-02-22", 0));
    }

    @Async
    public CompletableFuture<StoreAvailability> getAvailabilty(String storeNo) {
        Optional<StoreAvailability> storeAvailability = storeAvailabilityList.stream().filter(i->i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(storeAvailability.get());
    }

   // @Async
    public CompletableFuture<StoreCapacity> getCapacity(String storeNo) {
        Optional<StoreCapacity> storeCapacity = storeCapacityList.stream().filter(i->i.getStoreNo().equals(storeNo)).findFirst();
        return CompletableFuture.completedFuture(storeCapacity.get());
    }

    /***
     * Getting the stats of availability and capacity on the requested date
     * compares the requested date with the dates in the list get the available quantity on that reqDate
     * @param reqDate the date requested at the input
     * @return the string stats of specified scenario
     */
    public String getStatus(String reqDate){
        double availability = 0;
        availability = storeAvailabilityList.stream().filter(i -> i.getDate().equals(reqDate)).mapToDouble(i -> i.getAvailQty()).sum();
        double capacity = 0;
        capacity = storeCapacityList.stream().filter(i -> i.getDate().equals(reqDate)).mapToDouble(i -> i.getNoOfOrdersAccepted()).sum();

        if(availability == 0 && capacity ==0)
            return "No Content";
        else if(capacity ==0) //availability>0 && capacity==0
            return "No Capacity";
        else if(availability==0) //capacity>0 && availability==0
            return "No Availability";
        else // availability>0 && capacity>0
            return "Available";
    }
}

