package com.example.mobilemanager.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Promotion_ProductDTO {
//    private Long productId;

    private float promotionValue;

    private float totalPromotion;
}
