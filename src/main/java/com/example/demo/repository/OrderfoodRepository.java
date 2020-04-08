package com.example.demo.repository;

import com.example.demo.domain.Orderfood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderfoodRepository extends JpaRepository<Orderfood, Long> {
   
}
