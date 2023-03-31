package com.example.mobilemanager.Repository;

import com.example.mobilemanager.Entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity , Long> {
}
