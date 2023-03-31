package com.example.mobilemanager.Model.Mapper;

import com.example.mobilemanager.Entity.ProductEntity;
import com.example.mobilemanager.Model.DTO.ProdDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Builder
public class MapToDTO {
    public ProdDTO convertProdToDTO(ProductEntity pe){
        ProdDTO prodDTO = ProdDTO.builder()
                .pdtoid(pe.getProductId())
                .price(pe.getPrice())
                .image(pe.getImage())
                .productName(pe.getProductName())
                .memoryStick(pe.getMemoryStick())
                .camera(pe.getCamera())
                .memory(pe.getMemory())
                .operatingSystem(pe.getOperatingSystem())
                .battery(pe.getBattery())
                .size(pe.getSize())
                .color(pe.getColor())
                .warrantyPeriod(pe.getWarrantyPeriod())
                .promotionID(pe.getPromotionID()).build();
                return prodDTO;

    }
}
