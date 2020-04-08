package com.example.demo.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@NoArgsConstructor
@Table(name="delivery")
public class Delivery extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private  Long id;


    @OneToOne(mappedBy = "delivery") //mappedby : n:n 매핑시에 owner이 누군지 알려준다.
    private Order order;


    private String zipcode;

    private String street;

    @Enumerated(EnumType.STRING) //배달 정보넘김
    private DeliveryStatus status;

    @Enumerated(EnumType.STRING) //배달 정보넘김
    private Coupon coupon;

    //oneToone 매핑
    public void applyOrder(Order order){
        this.order = order;
    }

    public void DeliverySetOrder(Order order){
        this.order = order;
    }

    public void DeliverySetAddress_InOrder(String zipcode, String street){
        this.zipcode =zipcode;
        this.street = street;
    }

    public void DeliverySetstatus_InOrder(DeliveryStatus status){
        this.status = status;
    }

    public void DeliverySetcoupon_InOrder(Coupon coupon){
        this.coupon = coupon;
    }

}
