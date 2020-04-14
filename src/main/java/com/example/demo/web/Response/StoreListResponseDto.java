package com.example.demo.web.Response;


import com.example.demo.domain.Store;

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
