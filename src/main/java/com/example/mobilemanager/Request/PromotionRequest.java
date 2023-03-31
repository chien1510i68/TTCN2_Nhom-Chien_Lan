package com.example.mobilemanager.Request;

import com.example.mobilemanager.Entity.Promotion_ProductEntity;
import com.example.mobilemanager.validation.BirthDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Date;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PromotionRequest {
    @NotNull(message = "promotionValue is not null")
    private float promotionValue;

    @NotBlank(message = "startDate is not null")
    @BirthDate
    private String startDate;

    @NotBlank(message = "endtDate is not null")
    @BirthDate
    private String endtDate;


    private Promotion_ProductEntity promotion_productEntity;
}