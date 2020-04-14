package com.example.demo.domain.user;


import com.example.demo.domain.Address;
import com.example.demo.domain.BaseTimeEntity;
import com.example.demo.domain.Coupon;
import lombok.*;


import javax.persistence.*;
@Entity
@Getter
@NoArgsConstructor
public class Member extends BaseTimeEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "member_id")
        private Long id;

        @Column
        private String name;


//        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY) //oneToMany ; mappedBy = owner, fetch = 지연로딩
//        private List<Order> orders = new ArrayList<>();


//        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//        private List<Food> foods = new ArrayList<>();

//
//        @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
//        private List<Store> store = new ArrayList<>();

        @Embedded
        private Address address;

        @Enumerated(EnumType.STRING)
        private Coupon coupon;

        @Builder // 값변경.
        public  Member(String name, Address address, Coupon coupon) {
                this.name = name;
                this.address = address;
                this.coupon = coupon;
        }

//        public void Orderadd(Order order) {
//                order.setMember(this);
//                this.orders.add(order); //member값을 Oreder을 리스트에 더해준다.
//        }
//
//        public void Foodadd(Food food) {
//                food.Setfood_member(this);
//                this.foods.add(food); //member값을 Oreder을 리스트에 더해준다.
//        }

}
