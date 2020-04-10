package com.example.demo.web.Response;


import com.example.demo.domain.Store;
import com.example.demo.eating.chicken.BBQ;
import com.example.demo.eating.chicken.KFC;
import com.example.demo.eating.korea.KimbabHeaven;
import com.example.demo.eating.korea.Kimbabhell;
import com.example.demo.eating.pizza.Domino;
import com.example.demo.eating.pizza.PizzaHut;
import com.example.demo.eating.zokbal.Gazok;
import com.example.demo.eating.zokbal.HyeonwuZok;
import lombok.Getter;

@Getter
public class StoreListResponseDto {
    private Long id;
    private String name;
    private String tel;
    private String address;

    public StoreListResponseDto(Store entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.tel = entity.getTel();
        this.address = entity.getAddress();
    }
}
