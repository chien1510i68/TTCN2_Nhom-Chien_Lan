package com.example.mobilemanager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "promotion_product")
public class Promotion_ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "promotion_value")
    private float promotionValue;

    @Column(name = "total_promotion")
    private float totalPromotion;
}
