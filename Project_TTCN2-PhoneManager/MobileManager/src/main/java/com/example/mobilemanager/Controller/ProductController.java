package com.example.mobilemanager.Controller;

import com.example.mobilemanager.Constant.ErrorCodeDefs;
import com.example.mobilemanager.Model.DTO.ProdDTO;
import com.example.mobilemanager.Request.ProductReq.ProdRequest;
import com.example.mobilemanager.Response.ResponseError.BaseResponse;
import com.example.mobilemanager.Response.ResponseSuccess.ListProductResponse;
import com.example.mobilemanager.Response.ResponseSuccess.ProductResponse;
import com.example.mobilemanager.Service.Product.ProductServiceIplm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("prod/")
public class ProductController {
    @Autowired
    private ProductServiceIplm productService;

    //    Thêm sản phẩm :
    @PostMapping("create")
    public ResponseEntity<?> addProd(@Validated @RequestBody ProdRequest prodRequest) {
        ProdDTO prodDTO = productService.addMobile(prodRequest);
        ProductResponse productResponse = ProductResponse.builder()
                .success(true)
                .data(prodDTO).build();
        return ResponseEntity.ok(productResponse);
    }

    //    Tìm kiếm sản phẩm theo ID :
    @GetMapping("{id}")
    public ResponseEntity<?> getByID(@Validated @PathVariable(required = false) Long id) throws Exception {

            try {
                ProdDTO prodDTO = productService.getByID(id);
                ProductResponse productResponse = ProductResponse.builder()
                        .success(true)
                        .data(prodDTO).build();
                return ResponseEntity.ok(productResponse);
            } catch (Exception ex) {
                BaseResponse response = new BaseResponse();
                response.setFailed(ErrorCodeDefs.SERVER_ERROR, ex.getMessage());
                return ResponseEntity.ok(response);
            }


    }

    @GetMapping("")
    public ResponseEntity<?> getAllProd() {
        List<ProdDTO> dtoList = productService.getAllMobile();
        ListProductResponse listProductResponse = new ListProductResponse();
        listProductResponse.setSuccess(true);
        listProductResponse.setResult(dtoList.size(), dtoList);
        return ResponseEntity.ok(listProductResponse);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateProduct(@Validated @RequestBody ProdRequest prodRequest, @PathVariable long id) {
        try {
            ProdDTO prodDTO = productService.updateMobile(prodRequest, id);
            ProductResponse productResponse = ProductResponse.builder().success(true).data(prodDTO).build();
            return ResponseEntity.ok(productResponse);
        } catch (Exception ex) {
            BaseResponse baseResponse = new BaseResponse();
            BaseResponse response = new BaseResponse();
            response.setFailed(ErrorCodeDefs.SERVER_ERROR, ex.getMessage());
            return ResponseEntity.ok(response);
        }
    }

    @DeleteMapping("del/{id}")
    public ResponseEntity<?> deleteByID(@PathVariable (required = false) Long id) throws Exception {
      try{
          ProdDTO prodDTO = productService.deleteByID(id);
          ProductResponse productResponse = ProductResponse.builder().success(true).data(prodDTO).build();
          return ResponseEntity.ok(productResponse);
      }catch (Exception ex){
          BaseResponse baseResponse = new BaseResponse();
          BaseResponse response = new BaseResponse();
          response.setFailed(ErrorCodeDefs.SERVER_ERROR, ex.getMessage());
          return ResponseEntity.ok(response);
      }
    }
    @DeleteMapping("del/all")
    public ResponseEntity<?> deleteAll(@RequestBody List<Long> ids){
        List<ProdDTO> dtoList = productService.deleteList(ids);
        ListProductResponse listProductResponse = new ListProductResponse();
        listProductResponse.setSuccess(true);
        listProductResponse.setResult(dtoList.size(), dtoList);
        return ResponseEntity.ok(listProductResponse);
    }

}
