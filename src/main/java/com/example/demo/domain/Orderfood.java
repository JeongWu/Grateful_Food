package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orderfood")
public class Orderfood extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderfood_id")
    private Long id;

    @OneToMany(mappedBy = "orderfood")
    private List<Food> foods = new ArrayList<>();

    //Owner
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
        foods.add(food); // orderfoods라는 배열에 orderfood 하나의 이름을 저장한다.
        food.Setfood_orderfood(this);
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
