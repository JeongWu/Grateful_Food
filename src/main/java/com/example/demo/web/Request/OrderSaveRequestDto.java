package com.example.demo.web.Request;

import com.example.demo.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDto {
    private int stockQuantity;
    private DeliveryStatus status;
    private  Coupon coupon;

    @Builder
    //값 등록이 필요없다.
    public OrderSaveRequestDto(int stockQuantity, DeliveryStatus status, Coupon coupon){
//        member.getOrder().add(Order.builder().build()); //해당값 어떻게처리할가에대한 고민...
        this.coupon = coupon;
        this.stockQuantity = stockQuantity;
        this.status = status;
//        this.foods.add(food);
//        food.Food_Order(Order);


    }


    //builder로 값을 전달해준다.
    public Order toEntity(){
        return Order.builder()
                .coupon(coupon)
                .stockQuantity(stockQuantity)
                .build();
    }
}
