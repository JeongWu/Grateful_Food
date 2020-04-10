package com.example.demo.SaveRequest;


import com.example.demo.domain.*;
import com.example.demo.repository.*;
import com.example.demo.service.CommentService;
import com.example.demo.service.OrderService;
import com.example.demo.web.Request.OrderSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@Rollback(false)
public class OrderApiControllerTest {


    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private FoodRepository foodRepository;


//    @After
//    public void tearDown() throws Exception{
//        orderRepository.deleteAll();
//    }

    @Test
    public void order_등록된다() throws Exception{
        /**
         프론트에서 전송할 데이터
         1. 멤버정보
         2. 음식정보
         3. 쿠폰값
         4. 주소정보값
         5. 수량(개개인 음식수량) 어떻게 처리할까
         */
        Member member = memberRepository.findOne(1L);
        Food food = foodRepository.findOne(1L);

        OrderSaveRequestDto requestDto = OrderSaveRequestDto.builder()
                .coupon(member.getCoupon()) // 쿠폰사용유무
                .stockQuantity(2000) //수량 2000개
                .member(member)
                .build();

        /**
         * order세팅 저장완료
         */
        Long orderid = orderService.order(requestDto);

        //매핑 필요없다...
//        orderService.mappingOrder(requestDto, order, member);


        /**
         * orderfood 세팅을 어떻게 해줄까?
         */
        //****
        orderService.saveOrderfood(orderid, food);
//
//
//        String url = "http://localhost:" + port + "/Guest/order";
//
//        //when
//
//        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
//
//        //then
//        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
//
//        assertThat(responseEntity.getBody()).isGreaterThan(0L);
//
//        List<Order> all = orderRepository.findAll();
//        assertThat(all.get(0).getStockQuantity()).isEqualTo(2000);

    }
}
