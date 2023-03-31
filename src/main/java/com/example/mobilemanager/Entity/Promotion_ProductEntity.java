package com.example.mobilemanager.Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "promotion_product")
public class Promotion_ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_product_id")
    private Long productId;

    @Column(name = "promotion_value")
    private float promotionValue;

    @Column(name = "total_promotion")
    private float totalPromotion;

    @OneToMany(mappedBy = "promotion_productEntity" , cascade = CascadeType.ALL ,orphanRemoval = true)
    List<PromotionEntity> promotionEntities = new ArrayList<>();


}
