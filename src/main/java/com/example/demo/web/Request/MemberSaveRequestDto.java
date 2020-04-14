package com.example.demo.web.Request;


import com.example.demo.domain.Address;
import com.example.demo.domain.Coupon;
import com.example.demo.domain.Member;
import com.example.demo.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberSaveRequestDto {

    private String name;
    private String email;
    private String picture;
    private int password;
    private Address address;
    private Coupon coupon;
    private Role role;

    @Builder
    public MemberSaveRequestDto(String name, String email, String picture, int password, Address address, Coupon coupon, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.password = password;
        this.address = address;
        this.coupon = coupon;
        this.role = role;
    }

    public Member toEntity(){
        return Member.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .password(password)
                .address(address)
                .coupon(coupon)
                .role(role)
                .build();
    }
}
