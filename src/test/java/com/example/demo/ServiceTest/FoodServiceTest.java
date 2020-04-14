package com.example.demo.ServiceTest;


import com.example.demo.domain.Address;
import com.example.demo.domain.Food;
import com.example.demo.domain.Member;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.FoodService;
import com.example.demo.service.MemberService;
import com.example.demo.web.Response.FoodListResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodServiceTest {

    @Autowired
    FoodRepository foodRepository;
    @Autowired
    FoodService foodService;
    @Test
    public void Find() {


        List<Food> test = foodRepository.findAll();
        for(Food t : test) {
            if (t.getStore().getId() == 7) {
                System.out.println(t.getName());
            }
        }

        System.out.println("-----------구분선-----------");
        List<FoodListResponseDto> foods = foodService.findOne(7);

        for(FoodListResponseDto Dto : foods) {

            System.out.println(Dto.getName());

        }

    }
}
