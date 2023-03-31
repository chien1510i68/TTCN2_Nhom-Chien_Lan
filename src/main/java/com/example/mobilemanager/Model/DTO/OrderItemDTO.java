package com.example.mobilemanager.Model.DTO;

import com.example.mobilemanager.Entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDTO {
    private ProdDTO prodDTO;

    private OrderItemDTO orderItemDTO;



}
