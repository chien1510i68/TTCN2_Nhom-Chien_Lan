package com.example.mobilemanager.Model.DTO;

import com.example.mobilemanager.Entity.Promotion_ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromotionDTO {
    private float promotionValue;

    private Date startDate;

    private Date endtDate;

    private Promotion_ProductEntity promotion_productEntity;
}
