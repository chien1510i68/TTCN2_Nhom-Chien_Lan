package com.example.mobilemanager.Entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemID;

    @OneToOne
    @JoinColumn(name = "product_id" , referencedColumnName = "product_id")
    private ProductEntity productEntity;
}
