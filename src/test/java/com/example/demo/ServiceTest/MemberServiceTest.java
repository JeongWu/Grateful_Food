package com.example.demo.ServiceTest;


import com.example.demo.domain.*;
import com.example.demo.domain.user.Role;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.MemberRepository;

import com.example.demo.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.example.demo.domain.Coupon.이천원;
import static com.example.demo.domain.Coupon.천원;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(false)
public class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    MemberService memberService;


    @Test
    public void 회원가입_Test() throws Exception {
        String name = "정우";
        String street = "경기도";
        String zipcode = "오리";
        Address address = new Address(zipcode, street);


        Member member = new Member();
        memberRepository.save(member.builder()
                .name(name)
                .address(address)
                .coupon(이천원).role(Role.GUEST)
                .password(1234)
                .build());

        System.out.println("--------------------------");

        List<Member> mm = memberRepository.findAll();
        System.out.println(memberRepository.findOne(mm.get(0).getId()));
        Member members = mm.get(0);
        System.out.println(members.getCreatedDate());
        assertThat(members.getName()).isEqualTo(name);
        assertThat(members.getCoupon()).isEqualTo(이천원);
    }

    @Test
    public void 아이디비밀번호체크_Test() throws Exception {

        String name ="정우";
        int password = 1234;
        String result = memberService.check_login(name, password);
        assertThat(result).isEqualTo("YES");

    }



}

    /**
    @Test(expected = IllegalStateException.class)
    public void Test_overlap() throws Exception {


        List<Member> mm = memberRepository.findAll();
        Member member = mm.get(0);
        Member member2 = mm.get(1);
        memberService.SingUp(member);//save
        memberService.SingUp(member2); //save
        fail("예외가 발생해야 한다.");
    }
*/

