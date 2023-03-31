package com.example.mobilemanager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "promotion")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PromotionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private Long promotionID;

    @Column(name = "promotion_value")
    private float promotionValue;
    @Column(name = "start_date")
    private Timestamp startDate;
    @Column(name = "end_date")
    private Date endtDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "promotion_product_id")
    private Promotion_ProductEntity promotion_productEntity;
}
