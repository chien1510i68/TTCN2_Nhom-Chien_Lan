package com.example.mobilemanager.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {
    @Min(value = 1)
    private float price;

    @NotBlank(message = "image is not empty")
    private String image;

    @NotBlank(message = "product name is not empty")
    private String productName;

    @NotNull
    @Min(value = 1)
    private int memoryStick;

    @NotNull
    @Min(value = 1)
    private int camera;

    @NotNull
    @Min(value = 1)
    private int memory;

    @NotBlank(message = "operatingSystem is not null ")
    private String operatingSystem;

    @NotBlank(message = "battery is not null ")
    private String battery;

    @NotBlank(message = "size is not null ")
    private String size;

    @NotBlank(message = "color is not null ")
    private String color;

    @NotBlank(message = "warrantyPeriod is not null ")
    private String warrantyPeriod;

    @NotNull
    @Min(value = 1)
    private int promotionID;
}
