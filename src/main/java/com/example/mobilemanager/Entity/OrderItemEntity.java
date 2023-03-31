package com.example.mobilemanager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="order_item_id" )
    private Long orderItemId;

    @OneToOne
    @JoinColumn(name = "fk_product_id" , referencedColumnName = "product_id")
    private ProductEntity productEntity;

    @OneToOne
    @JoinColumn(name = "fk_promotion_product_id" , referencedColumnName = "promotion_product_id")
    private Promotion_ProductEntity promotion_productEntity;


}
