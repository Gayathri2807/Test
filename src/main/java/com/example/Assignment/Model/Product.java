package com.example.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Product {
    private String productId;
    private String productName;
    private String unitOfMeasure;
    private String launchDate;

}
