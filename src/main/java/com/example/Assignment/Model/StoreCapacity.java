package com.example.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StoreCapacity {
    private String storeNo;
    private String productId;
    private String date;
    private double noOfOrdersAccepted;
}
