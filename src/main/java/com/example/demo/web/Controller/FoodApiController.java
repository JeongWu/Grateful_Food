package com.example.demo.web.Controller;

import com.example.demo.domain.Food;
import com.example.demo.repository.FoodRepository;
import com.example.demo.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class FoodApiController {
    private final FoodService foodService;
    private final FoodRepository foodRepository;

    @PostMapping("/api/v1/posts") //모든 음식 목록을 보여준다
    public Food find(@PathVariable Long id){

         return foodRepository.findOne(id);
    }

}
