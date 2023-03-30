package com.example.mobilemanager.Service.Product;

import com.example.mobilemanager.Entity.ProductEntity;
import com.example.mobilemanager.Model.DTO.ProdDTO;
import com.example.mobilemanager.Request.ProductReq.ProdRequest;

import java.util.List;

public interface ProductService {

    ProdDTO addMobile(ProdRequest prodRequest);
    ProdDTO getByID(long id) throws Exception;
    List<ProdDTO> getAllMobile();
    ProdDTO updateMobile(ProdRequest prodRequest , long id) throws Exception;
    ProdDTO deleteByID(Long id) throws Exception;
    List<ProdDTO> deleteList(List<Long> ids);

}
