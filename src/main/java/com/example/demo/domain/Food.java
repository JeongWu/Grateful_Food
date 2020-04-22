package com.example.demo.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Ftype")
@Getter
@Embeddable
public class Food { //builder로 값을 넘겨줘야함.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 인덱스 ++ 만드는것
    @Column(name = "food_id")
    private Long id;

    protected String name;

    public int price;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;

    public Food(){

    }
   public void NamePrice(String name, int price){
       this.name = name;
       this.price = price;
   }

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "orderfood_id")
//    private Orderfood orderfood;
//
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private Member member;

//    public void Setfood_orderfood(Orderfood orderfood){
//        this.orderfood = orderfood;
//    }
//
//
//
//    public void Setfood_order(Order order){
//        this.order = order;
//    }
//
//    public void Setfood_member(Member member){
//        this.member =member;
//    }
//


}