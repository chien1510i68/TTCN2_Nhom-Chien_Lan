package com.example.mobilemanager.Controller;

import com.example.mobilemanager.Model.DTO.PromotionDTO;
import com.example.mobilemanager.Request.PromotionRequest;
import com.example.mobilemanager.Service.Promotion.PromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/promotion/")
public class PromotionController {
    @Autowired
    private PromotionService promotionService;


    @PostMapping("create")
    public ResponseEntity<?> createPromotion(@Valid @RequestBody PromotionRequest request){
        PromotionDTO  dto = promotionService.createPromotion(request);
        return ResponseEntity.ok(dto);
    }
}
