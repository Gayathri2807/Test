package com.example.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class StoreAvailability {
    private String storeNo;
    private String productId;
    private String date;
    private double availQty;
}
