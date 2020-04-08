package com.example.demo.repository;

import com.example.demo.domain.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface FoodRepository extends JpaRepository<Food, Long> {


    @Query("SELECT m FROM Food m where m.id = :id")
    Food findOne(Long id);

    @Query("SELECT m FROM Food m")
    List<Food> findAll();
}
