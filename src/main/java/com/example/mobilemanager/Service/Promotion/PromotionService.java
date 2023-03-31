package com.example.mobilemanager.Service.Promotion;

import com.example.mobilemanager.Entity.PromotionEntity;
import com.example.mobilemanager.Model.DTO.PromotionDTO;
import com.example.mobilemanager.Repository.PromotionRepository;
import com.example.mobilemanager.Request.PromotionRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Optional;

@Service
public class PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private ModelMapper mapper;

    public PromotionDTO createPromotion(@RequestBody PromotionRequest request){
        PromotionEntity promotionEntity = PromotionEntity.builder()
                .promotionValue(request.getPromotionValue())
                .startDate(Timestamp.valueOf(request.getStartDate()))
                .endtDate(Timestamp.valueOf(request.getEndtDate()))
                .build();
        promotionRepository.save(promotionEntity);

        return mapper.map(promotionEntity,PromotionDTO.class );
    }

}
