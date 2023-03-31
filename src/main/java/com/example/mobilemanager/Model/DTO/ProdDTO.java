package com.example.mobilemanager.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProdDTO {
    private long pdtoid ;
    private float price ;
    private String image;
    private  String productName;
    private int memoryStick;
    private int camera;
    private int memory;
    private String operatingSystem;
    private String battery;
    private String size;
    private String color;
    private String warrantyPeriod;
    private int promotionID;
}
