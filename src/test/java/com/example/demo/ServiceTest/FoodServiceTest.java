package com.example.demo.ServiceTest;


import com.example.demo.domain.Address;
import com.example.demo.domain.Food;
import com.example.demo.domain.Member;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodServiceTest {

    @Autowired
    FoodRepository foodRepository;
    @Test
    public void Find() {

        Food food = foodRepository.findAllDesc("파닭치킨");

        System.out.println(food.getName());
        assertThat(food.getName()).isEqualTo("파닭치킨");

    }
}
