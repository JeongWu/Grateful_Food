package com.example.demo.service;




import com.example.demo.domain.Food;
import com.example.demo.repository.FoodRepository;

import com.example.demo.web.Response.FoodResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class FoodService {
    private final FoodRepository foodRepository;

    //푸드정보 보여준다 음식별로...
    @Transactional(readOnly = true)
    public FoodResponseDto findAllDesc(String name) {
        Food entity = foodRepository.findAllDesc(name);

        return new FoodResponseDto(entity);
    }

}
//
//
//
//
//
//    /**
//     *  필요없음
//     * @return
//
//    public List<Food> findFoods() {
//        return foodRepository.findAll(); //푸드정보
//    }
//
//
//    @Transactional(readOnly =true)
//    public Food findOne(Long foodId) {
//        return foodRepository.findOne(foodId);
//    }
//
//    @Transactional
//    public Long SingUp(Food food) {
//        foodRepository.save(food);
//        return food.getId();
//    }
//     */
//}
//
//
