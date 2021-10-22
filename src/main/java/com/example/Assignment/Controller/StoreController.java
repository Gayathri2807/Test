package com.example.Assignment.Controller;

import com.example.Assignment.Model.StoreAvailability;
import com.example.Assignment.Model.StoreCapacity;
import com.example.Assignment.Model.StoreInput;
import com.example.Assignment.Model.StoreOutput;
import com.example.Assignment.Service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
public class StoreController {

    @Autowired
    private StoreService storeService;

   /* @GetMapping("/getAvailability")
    public List<StoreAvailability> getAvailability(){
        return storeService.getAvailabilityList();
    }

    @GetMapping("/getCapacity")
    public List<StoreCapacity> getCapacity(){
        return storeService.getCapacityList();
    }

  */
    @PostMapping("/getProdAvailability")
    public ResponseEntity<StoreOutput> getProductAvailability(@RequestBody StoreInput storeInput){
       storeService.getAvailabilityList();
       storeService.getCapacityList();

        CompletableFuture<StoreAvailability> storeAvailability = storeService.getAvailabilty(storeInput.getStoreNo());
        CompletableFuture<StoreCapacity> storeCapacity= storeService.getCapacity(storeInput.getStoreNo());
        CompletableFuture.allOf(storeAvailability,storeCapacity).join();
        String status = storeService.getStatus(storeInput.getReqDate());
        if(status.equals("No Capacity") || status.equals("No Availability") || status.equals("Available")){
            StoreOutput storeOutput = new StoreOutput(storeInput,status);
            return new ResponseEntity<StoreOutput>(storeOutput, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
