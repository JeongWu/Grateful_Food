package com.example.demo.web.Request;

import com.example.demo.domain.Address;
import com.example.demo.domain.Coupon;
import com.example.demo.domain.Member;
import com.example.demo.domain.user.Role;
import lombok.Builder;
import lombok.Getter;


@Getter
public class MemberUpdateRequestDto {

    private String name;
    private String email;
    private String picture;
    private int password;
    private Address address;
    private Coupon coupon;
    private Role role;

    @Builder
    public MemberUpdateRequestDto(String name, String email, String picture, int password, Address address, Coupon coupon, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.password = password;
        this.address = address;
        this.coupon = coupon;
        this.role = role;
    }
}
