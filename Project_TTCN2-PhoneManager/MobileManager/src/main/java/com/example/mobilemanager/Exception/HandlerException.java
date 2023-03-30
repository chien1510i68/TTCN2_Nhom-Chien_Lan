package com.example.mobilemanager.Exception;

import com.example.mobilemanager.Constant.ErrorCodeDefs;
import com.example.mobilemanager.Response.ResponseError.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class HandlerException {




    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        BaseResponse baseResponse = BaseResponse.builder()
                .success(false)
                .error(processFielError(fieldErrors)).build();
        return baseResponse;
    }

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public BaseResponse httpMediaTypeNotAcceptableException(HttpMediaTypeNotAcceptableException ex){
        return    BaseResponse.builder().success(false).error(
                BaseResponse.Error.builder().status(ErrorCodeDefs.VALIDATION_ERROR)
                        .message(ErrorCodeDefs.getErrMsg(ErrorCodeDefs.VALIDATION_ERROR)).build()
        ).build();
    }
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public BaseResponse methodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        return BaseResponse.builder().success(false).error(
                BaseResponse.Error.builder().status(ErrorCodeDefs.BAD_REQUEST)
                        .message(ErrorCodeDefs.getErrMsg(ErrorCodeDefs.BAD_REQUEST)).build()
        ).build();
    }

    private BaseResponse.Error processFielError(List<FieldError> fieldErrors) {
        BaseResponse.Error error = BaseResponse.Error.builder().status(ErrorCodeDefs.VALIDATION_ERROR)
                .message(ErrorCodeDefs.getErrMsg(ErrorCodeDefs.VALIDATION_ERROR)).build();
        List<BaseResponse.DetailError> detailErrorList = new ArrayList<>();
        for (FieldError fieldError : fieldErrors) {
            BaseResponse.DetailError detailError = BaseResponse.DetailError.builder().message(fieldError.getDefaultMessage())
                    .id(fieldError.getField()).build();
            detailErrorList.add(detailError);
        }
        error.setDetailErrorList(detailErrorList);
        return error;
    }



}
