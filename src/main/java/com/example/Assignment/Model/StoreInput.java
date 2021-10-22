package com.example.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StoreInput {
    private String storeNo;
    private String productId;
    private double reqQty;
    private String reqDate;
}

