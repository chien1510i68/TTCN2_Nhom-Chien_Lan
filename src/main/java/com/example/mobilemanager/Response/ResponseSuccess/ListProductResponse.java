package com.example.mobilemanager.Response.ResponseSuccess;

import com.example.mobilemanager.Model.DTO.ProdDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class ListProductResponse {
    private boolean success = true;
    private ListProd<ProdDTO> data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
    public static class ListProd<ProdDTO>  {
        private long total;
        private List<ProdDTO> listProduct;
    }
    public void setResult(long total, List<ProdDTO> items) {
        data = new ListProd<>();
        data.setListProduct(items);
        data.setTotal(total);
    }
}
