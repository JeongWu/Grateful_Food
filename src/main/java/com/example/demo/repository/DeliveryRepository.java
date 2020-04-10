//package com.example.demo.repository;
//
//import com.example.demo.domain.Delivery;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
//
//    @Query("SELECT d FROM Delivery d where d.id = :id")
//    Delivery findOne(Long id);
//}
