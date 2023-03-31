package com.example.mobilemanager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order_product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId ;

    @Column(name = "quantity")
    private int quantity ;

    @Column(name = "addr")
    private String addr ;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "total_value")
    private Float totalValue;

    @Column(name = "status_id")
    private int statusId;
}
