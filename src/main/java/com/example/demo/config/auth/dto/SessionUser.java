package com.example.demo.config.auth.dto;
import com.example.demo.domain.BaseTimeEntity;
import com.example.demo.domain.Member;
import lombok.Getter;


import java.io.Serializable;

@Getter
public class SessionUser extends BaseTimeEntity implements Serializable  {
    private String name;
    private String email;
    private String picture;

    public SessionUser(Member member) {
        this.name = member.getName();
        this.email = member.getEmail();
        this.picture = member.getPicture();
    }
}