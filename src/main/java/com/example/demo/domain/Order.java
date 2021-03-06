package com.example.demo.domain;



import com.example.demo.exception.NotEnoughStockException;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Table(name = "orders")
@NoArgsConstructor
public class Order extends BaseTimeEntity {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) //member 과 order을 n:1로 매핑시킨다
    @JoinColumn(name = "member_id") //외래키생성. many에서만 생성된다.
    private Member member;



    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL )
    private List<Orderfood> orderfoods = new ArrayList<>();

    /*
      엔티티 Cascade는 엔티티의 상태 변화를 전파시키는 옵션
     단방향 혹은 양방향으로 매핑되어 있는 엔티티에 대해 어느 한쪽 엔티티의 상태(생성 혹은 삭제)가 변경되었을 시
     그에 따른 변화를 바인딩된 엔티티들에게 전파하는 것을 의미.
출처: https://engkimbs.tistory.com/817 [새로비]
     */


    private int stockQuantity;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status;

    @Enumerated(EnumType.STRING)
    private Coupon coupon;



//    public void applyDelivery(Delivery delivery){
//        this.delivery = delivery;
//        delivery.applyOrder(this);
//    }


    public void setMember(Member member) {
        this.member = member; //member값을 입력받는다
    }




    public void addOrderFood(Orderfood orderfood) {
        orderfood.setOrder(this);
        orderfoods.add(orderfood); // orderfoods라는 배열에 orderfood 하나의 이름을 저장한다.
    }



//    public void addFood(Food food) {
//        food.Setfood_order(this);
//        this.foods.add(food);
//    }




//필요없음
//    public void setOrderfoods(List<Orderfood> orderfood ) {
//        for(Orderfood orderfoods : orderfood){
//            addOrderFood(orderfoods);
//        }
//    }

    /**
     *  이거 주문 생성 할때 만드는 것임 만약에 필요한 경우에 새롭게 추가추가
     *  해서 넣기만 하면 ok
     */



    @Builder
    public Order(int stockQuantity, Coupon coupon, Member member) {
        SetReady_DeliveryStatus(DeliveryStatus.READY); //디폴트값
        this.stockQuantity = stockQuantity;
        this.coupon = coupon;
        this.member =member;
    }




    public void SetReady_DeliveryStatus(DeliveryStatus status){
        this.status = status;
    }
    /**
     * 주문 후에 취소 상태를 보여준다
     */

    //cancle하기위해서 필수이다.
    public  void cancel() {
        if(this.getStatus() == DeliveryStatus.ARRIVE) {
            throw new IllegalStateException("출발은 상태에서는 취소 하실 수" +
                    "없습니다.");
        }
        this.SetCancle_DeliveryStatus(DeliveryStatus.CANCEL);
        for(Orderfood orderfood : orderfoods) {
            orderfood.cancel();
        }
        return;
    }

    public void SetCancle_DeliveryStatus(DeliveryStatus status){
        this.status = status;
    }

    /**
     * 주문 가격 합을 모두 가져와 보여줍니당
     */

    public int getTotalPrice() {
        int totalPrice =0;
        for(Orderfood orderfood : orderfoods) {
            totalPrice +=orderfood.getTotalPrice();
        }

        return totalPrice;

    }
    /**
     * 장바구니를 control하는 함수 위의 cancel함수와 차이가있습니다.
     */
    public void basket_cancel(int quantity) //+, - 둘다 해당함수 불러옴
    {

        if (stockQuantity == 1) {
            throw new NotEnoughStockException("non click sub");
        }
        else if (stockQuantity >= 100) {
            throw new NotEnoughStockException("non click add");
        }

        this.stockQuantity += quantity; //취소버튼을 누를경우 -1값이 넘어간

        return;

    }

}
