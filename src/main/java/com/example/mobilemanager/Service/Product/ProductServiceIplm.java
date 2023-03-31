package com.example.mobilemanager.Service.Product;

import com.example.mobilemanager.Entity.ProductEntity;
import com.example.mobilemanager.Model.DTO.ProdDTO;
import com.example.mobilemanager.Model.Mapper.MapToDTO;
import com.example.mobilemanager.Repository.ProductRepoSitory;
import com.example.mobilemanager.Request.ProductRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceIplm implements ProductService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductRepoSitory productRepo;
    @Autowired
    private MapToDTO mapper;

    @Override
    public ProdDTO addMobile(ProductRequest productRequest) {
        ProductEntity entity = ProductEntity.builder()
                .price(productRequest.getPrice())
                .image(productRequest.getImage())
                .productName((productRequest.getProductName()))
                .memoryStick(productRequest.getMemoryStick())
                .camera(productRequest.getCamera())
                .memory(productRequest.getMemory())
                .operatingSystem(productRequest.getOperatingSystem())
                .battery(productRequest.getBattery())
                .size(productRequest.getSize())
                .color(productRequest.getColor())
                .warrantyPeriod(productRequest.getWarrantyPeriod())
                .promotionID(productRequest.getPromotionID()).build();
        productRepo.save(entity);

        return mapper.convertProdToDTO(entity);
    }

    @Override
    public ProdDTO getByID(long id) throws Exception {
        Optional<ProductEntity> entity = productRepo.findById(id);
        ProductEntity productEntity;
        if (!entity.isPresent()) {
            throw new Exception("ID is invalid");
        } else {
            productEntity = entity.get();
        }
//        ProdDTO prd =  ProductMapper.INSTANCE.toProdentityToProductDTO(productEntity);
//        return prd;
//        return mapper.convertProdToDTO(productEntity);
        return modelMapper.map(productEntity ,ProdDTO.class);



    }

    @Override
    public List<ProdDTO> getAllMobile() {
        List<ProdDTO> dtoList = new ArrayList<>();
        for (ProductEntity entity : productRepo.findAll()) {
            dtoList.add(mapper.convertProdToDTO(entity));
        }
        return dtoList;
    }

    @Override
    public ProdDTO updateMobile(ProductRequest pe, long id) throws Exception {
        Optional<ProductEntity> productEntity = productRepo.findById(id);
        if (!productEntity.isPresent()) {
            throw new Exception("ID is invalid");
        } else {
            ProductEntity entity = productEntity.get();
            entity.setPrice(pe.getPrice());
            entity.setImage(pe.getImage());
            entity.setProductName(pe.getProductName());
            entity.setMemoryStick(pe.getMemoryStick());
            entity.setCamera(pe.getCamera());
            entity.setMemory(pe.getMemory());
            entity.setOperatingSystem(pe.getOperatingSystem());
            entity.setBattery(pe.getBattery());
            entity.setSize(pe.getSize());
            entity.setColor(pe.getColor());
            entity.setWarrantyPeriod(pe.getWarrantyPeriod());
            entity.setPromotionID(pe.getPromotionID());
            productRepo.save(entity);

            return mapper.convertProdToDTO(entity);
        }
    }

    @Override
    public ProdDTO deleteByID(Long id) throws Exception {
        Optional<ProductEntity> entity = productRepo.findById(id);
        if (!entity.isPresent()) {
            throw new Exception("ID is invalid");
        } else {
            productRepo.deleteById(id);
            ProductEntity productEntity = entity.get();
            return mapper.convertProdToDTO(productEntity);
        }
    }

    @Override

    public List<ProdDTO> deleteList(List<Long> ids) {
       List<ProdDTO> dtoList = new ArrayList<>();
       for(ProductEntity entity : productRepo.findAllById(ids)){
//           dtoList.add(ProductMapper.INSTANCE.toProdentityToProductDTO(entity));
           dtoList.add(modelMapper.map(entity , ProdDTO.class));
       }
       productRepo.deleteAllByIdInBatch(ids);
        return dtoList;

    }
}