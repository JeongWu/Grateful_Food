//package com.example.demo.web.Response;
//
//
//import com.example.demo.domain.*;
//import com.example.demo.service.OrderService;
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
////주문 정보
//@Getter
//public class OrderListResponseDto {
//
//        @Autowired
//        OrderService orderService;
//        private DeliveryStatus status;
//        private int stockQuantity;
//        private Delivery delivery;
//        private List<Food> food = new ArrayList<>();
//
//    public OrderListResponseDto(Order entity){
//        this.status = entity.getStatus();
//        this.stockQuantity=entity.getStockQuantity();
////        this.food = entity.getFood();
//
//    }
//}
