package com.example.demo.domain;

import com.example.demo.eating.chicken.BBQ;
import com.example.demo.eating.chicken.KFC;
import com.example.demo.eating.korea.KimbabHeaven;
import com.example.demo.eating.korea.Kimbabhell;
import com.example.demo.eating.pizza.Domino;
import com.example.demo.eating.pizza.PizzaHut;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity
/**
 * 치킨 : KFC, BBQ
 * 피자 : 도미노, 피자헛
 * 한식 : 김밥천국, 김밥지옥
 * 족발 : 가장맛있는족발, 현우네족발
 */
public class Store extends BaseTimeEntity {


    //디비에저장
    @Id
    @GeneratedValue
    @Column(name = "storse_id")
    private Long id;

    @Column(name = "store_name")
    private String name;

    @Column(name = "store_tel")
    private String tel;


    @Column(name = "store_address")
    private String address; //가게주소 입력 변경사항 -> address클래스에서 직접 입력하는 변수명으로 바꿈


    @Column(name = "store_coupon")
    private int s_coupon;


    @ManyToOne
    @JoinColumn(name="domino_id")
    private Domino domino;

    @ManyToOne
    @JoinColumn(name = "hut_id")
    private PizzaHut pizzaHut;

    @ManyToOne
    @JoinColumn(name="bbq_id")
    private BBQ bbq;

    @ManyToOne
    @JoinColumn(name= "kfc_id")
    private KFC kfc;

    @ManyToOne
    @JoinColumn(name = "heaven_id")
    private KimbabHeaven kimbabHeaven;

    @ManyToOne
    @JoinColumn(name = "hell_id")
    private Kimbabhell kimbabhell;



    @Builder //사용자에게 입력받는 정보 + 사용자에게 해당정보를 보여준다.
    public Store(String name, String tel, String address, int s_coupon) {
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.s_coupon = s_coupon;
    }

}
