package com.example.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Calendar {
    public static final Integer SAT = 6;
    public static final Integer SUN = 0;
    public static final Integer MON = 1;
    public static final Integer TUE = 2;
    public static final Integer WED = 3;
    public static final Integer THU = 4;
    public static final Integer FRI = 5;
    private String locationID;
    private String Day;
    private String cutOffTime;
}
