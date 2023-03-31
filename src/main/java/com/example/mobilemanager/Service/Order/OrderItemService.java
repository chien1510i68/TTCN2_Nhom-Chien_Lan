package com.example.mobilemanager.Service.Order;

import com.example.mobilemanager.Entity.OrderItemEntity;
import com.example.mobilemanager.Model.DTO.OrderItemDTO;
import com.example.mobilemanager.Repository.OrderItemRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository orderItemRepository;
    @Autowired
    private ModelMapper  mapper ;

//    create order item


//    get order item by id :
    public OrderItemDTO getOrderItem(Long id) throws Exception {
        Optional<OrderItemEntity> orderItemEntity = orderItemRepository.findById(id);
        if(!orderItemEntity.isPresent()){
            throw new Exception("ID not found !");
        }
        return mapper.map(orderItemEntity.get() ,OrderItemDTO.class );
    }



}
