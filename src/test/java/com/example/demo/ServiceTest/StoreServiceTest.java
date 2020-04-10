package com.example.demo.ServiceTest;


import com.example.demo.domain.Food;
import com.example.demo.domain.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.StoreService;
import com.example.demo.web.Response.StoreListResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class StoreServiceTest {

    @Autowired
    StoreRepository storeRepository;

    @Autowired
    StoreService storeService;



    @Test
    public void FindPizza_Test(){

        List<Store> storess = storeService.findname("BBQ");
//        List<StoreListResponseDto> stores= storeService.findAllPizza();
        System.out.println("---------------result1--------------------");
//        stores.get(0).getName();
        System.out.println("---------------result2--------------------");



        /**
         *       store :  가게이름, 전화번호, food : 음식이름, 음식 가격, domino :맛, 종류 정보까지
         */

//        store.get()

    }


}
