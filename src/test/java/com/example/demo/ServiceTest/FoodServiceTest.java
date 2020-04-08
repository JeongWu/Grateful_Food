package com.example.demo.ServiceTest;


import com.example.demo.domain.Address;
import com.example.demo.domain.Food;
import com.example.demo.domain.Member;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.FoodService;
import com.example.demo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.example.demo.domain.Coupon.천원;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class FoodServiceTest {

    @Autowired
    FoodRepository foodRepository;

    @Autowired
    FoodService foodService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberService memberService;



    @Test
    public void Insert_Test() throws Exception {


        Food food = new Food();
        foodRepository.save(food.builder()
        .name("족발")
        .price(2000)
        .build());


    }
//        치킨, 피자, 중식, 일식, 한식, 족발

}
