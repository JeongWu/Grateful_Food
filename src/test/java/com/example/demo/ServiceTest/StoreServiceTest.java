package com.example.demo.ServiceTest;


import com.example.demo.domain.Store;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.FoodService;
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

    @Autowired
    FoodService foodService;



    @Test
    public void FindPizza_Test(){


        Store store = new Store();
        List<StoreListResponseDto> stores = storeService.findStore(store);

        StoreListResponseDto s = foodService.findStore(2);
        System.out.println(s.getName());

//        System.out.println("--------------------------");
//        String name ="BBQ";
//        String name2 ="KFC";
//
//        System.out.println("---------------result--------------------");
//        for(StoreListResponseDto test : stores) {
//            System.out.println(test.getName());
//            if(test.getName() == "BBQ" || test.getName()== "KFC") {
//                System.out.println("kkkkkkkkkkkkk");
//            }
//        }
//
//            System.out.println("---------------result2--------------------");
//
//        for(int i =0; i<stores.size(); i++){
//            if(stores.get(i).getName() == "BBQ" || stores.get(i).getName()=="KFC"){
//                System.out.println(stores.get(i).getAddress());
//            }
//        }
    }



        /**
         *       store :  가게이름, 전화번호, food : 음식이름, 음식 가격, domino :맛, 종류 정보까지
         */



}
