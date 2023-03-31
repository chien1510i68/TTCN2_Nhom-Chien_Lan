package com.example.mobilemanager.Response.ResponseSuccess;

import com.example.mobilemanager.Model.DTO.ProdDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {
    private boolean success = true;
    private ProdDTO data ;
}
