package com.example.demo.web.Response;

import com.example.demo.domain.Category;
import lombok.Getter;

@Getter
public class CategoryListResponseDto {
    private Long id;
    private String name;

    public CategoryListResponseDto(Category entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }




}
