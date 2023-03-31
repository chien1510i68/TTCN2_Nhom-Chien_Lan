package com.example.mobilemanager.Model.Mapper;

import com.example.mobilemanager.Entity.ProductEntity;
import com.example.mobilemanager.Model.DTO.ProdDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProdDTO toProdentityToProductDTO(ProductEntity productEntity);

}
