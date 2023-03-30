package com.example.mobilemanager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long id ;

    @Column
    private float price ;

    @Column
    private String image;

    @Column(name = "product_name")
    private  String productName;

    @Column(name = "memory_stick")
    private int memoryStick;

    @Column
    private int camera;
    @Column
    private int memory;
    @Column(name = "operating_system")

    private String operatingSystem;

    @Column
    private String battery;
    @Column
    private String size;
    @Column
    private String color;
    @Column(name = "warranty_period")
    private String warrantyPeriod;
    @Column(name = "promotion_id")
    private int promotionID;

}
