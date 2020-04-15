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
    public MemberUpdateRequestDto(Member entity) {
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.picture = entity.getPicture();
        this.password = entity.getPassword();
        this.address = entity.getAddress();
        this.coupon = entity.getCoupon();
        this.role = entity.getRole();
    }
}
