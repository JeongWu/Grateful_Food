package com.example.demo.web.Response;


import com.example.demo.domain.Food;
import lombok.Getter;

/**
 * 가게별 음식목록
 */
@Getter
public class FoodResponseDto {

    private Long id;
    private String name;
    private int price;


    public FoodResponseDto(Food entity){
        this.id = entity.getId();
        this.name = entity.getName(); // 푸드이름
        this.price = entity.getPrice(); // 가격
    }
}
