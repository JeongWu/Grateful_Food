package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.mapping.Join;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orderfood")
/**
 * member 과 order => 1:n 관계 한명이 여러주문을 할 수 있다.
 * order 와 food => n:n 하나의 주문 여러개 음식, 여러개 주문 여러개음식
 * ordder : orderfood 1:n
 * food : orderfood n:1
 */
public class Orderfood extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderfood_id")
    private Long id;


//    @OneToMany(mappedBy = "orderfood")
//    private List<Food> foods = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "food_id")
    private Food food;

    /**
     * Order한번에 여러주문을 넣어줄 수 있다.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderprice; //어떻게 계산할것인가

    private int count;

    private  int discount; //어떻게 계산할것인가




    protected Orderfood() {

    }

    //같은 로직만 적용이 되도록 막아놓기 위한 코드임 ->

    public static Orderfood createOrderfood(Food food, int count) {
        Orderfood orderfood = new Orderfood();
        orderfood.Orderfood_Food(food);
        orderfood.count = count;
        orderfood.Total_price(food.getPrice()); //가격을 어떻게 설정할 것인가.

        return orderfood;

    }

    public void Orderfood_Food(Food food) {
//        foods.add(food); // orderfoods라는 배열에 orderfood 하나의 이름을 저장한다.
//        food.Setfood_orderfood(this);
        this.food = food;
    }



    public void Total_price(int orderprice){
        this.orderprice = orderprice;
    }

    public void cancel() { //주문중 취소
        getOrder().cancel();
    }


    //총가

    public int getTotalPrice() {
        return getOrderprice() * getCount()-getDiscount();
    }


}
