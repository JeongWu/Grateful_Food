//package com.example.demo.ServiceTest;
//
//
//import com.example.demo.domain.*;
//import com.example.demo.repository.DeliveryRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//import static com.example.demo.domain.Coupon.천원;
//import static org.assertj.core.api.Assertions.assertThat;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@Transactional
//public class DeliveryServiceTest {
//
//    @Autowired
//    DeliveryRepository deliveryRepository;
//
//
//    @Test
//    public void Find_Test(){
//        List<Delivery> mm = deliveryRepository.findAll();
//
//        Delivery delivery = mm.get(0);
//        assertThat(delivery.getCoupon()).isEqualTo(천원);
//        assertThat(delivery.getStatus()).isEqualTo(DeliveryStatus.ARRIVE);
//    }
//}
