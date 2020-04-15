package com.example.demo.service;



import com.example.demo.domain.*;
import com.example.demo.repository.*;
import com.example.demo.web.Request.OrderSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final FoodRepository foodRepository;
    private final StoreRepository storeRepository;
    private final OrderfoodRepository orderfoodRepository;


    /**
     * 주문 / 취소 / 검색 로직을 담겨 있습니다.
     */

    /**
     *
     * @param orderSaveRequestDto
     * 웹에서 데이터받아 order저장시에
     * delivery 정보 저장 + orderfood 정보 저장
     *
     */


    // 트랜잭션 3개 묶기
    @Transactional
    public Long order(OrderSaveRequestDto orderSaveRequestDto) {
        return orderRepository.save(orderSaveRequestDto.toEntity()).getId();

    }

    //orderfood매핑하기
    @Transactional
    public void saveOrderfood(Long id, Food food, Orderfood... orderfoodss){
        Order order = orderRepository.findOne(id);
        //  //음식 주문로직 -> 음식 , 가격 , 개수가 담겨 있음 -> 문제는 추후 계산 문제
        // 하나밖에 못가져온다 값을...
        Orderfood orderfood = Orderfood.createOrderfood(food,order.getStockQuantity());
        order.addOrderFood(orderfood); //
//        for(Orderfood orderfoods : orderfoodss){
//            order.addOrderFood(orderfoods);
//        }

        orderfoodRepository.save(orderfood);

    }





//    @Transactional
//    public void mappingOrderfood(Orderfood... orderfood){
//        Order order = orderRepository.findOne()
//        for(Orderfood orderfoods : orderfood) {
//            order.addOrderFood(orderfoods);
//        }
//    }


    //취소
    @Transactional
    public void cancelOrder(Long orderId, Long foodId, Long StoreId) {

        //주문 내역 조회 -> 내정보에서 확인
        Order order = (Order) orderRepository.findOne(orderId); // STATUS
        Food food = foodRepository.findOne(foodId); //음식이름 ,가격
        Store store = storeRepository.findOne(StoreId); //가게이름, 번호

        //주문 취소 로직
        order.cancel();
    }

    @Transactional
    public void cancelbasketOrder(Long foodId, Long orderId) {

        Order order = orderRepository.findOne(orderId);
        Food food = foodRepository.findOne(foodId); //음식이름 ,가격
        //주문 취소 로직

        order.basket_cancel(order.getStockQuantity());
    }

}





//cascade -> 정보 다날려~
