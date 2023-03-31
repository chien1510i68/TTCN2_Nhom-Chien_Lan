package com.example.mobilemanager.Service.Product;

import com.example.mobilemanager.Model.DTO.ProdDTO;
import com.example.mobilemanager.Request.ProductRequest;

import java.util.List;

public interface ProductService {

    ProdDTO addMobile(ProductRequest productRequest);
    ProdDTO getByID(long id) throws Exception;
    List<ProdDTO> getAllMobile();
    ProdDTO updateMobile(ProductRequest productRequest, long id) throws Exception;
    ProdDTO deleteByID(Long id) throws Exception;
    List<ProdDTO> deleteList(List<Long> ids);

}
