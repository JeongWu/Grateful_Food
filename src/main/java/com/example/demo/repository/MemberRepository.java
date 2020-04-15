package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m where m.email =  :email")
    List<Member> findByEmail(String name);
    @Query("SELECT m FROM Member m where m.id = :id")
    Member findOne(Long id);

    @Query("SELECT m FROM Member m where m.email = :email AND m.password = :password")
    Member findByEmailPassword(Object email, Object password);

    @Modifying
    @Query("UPDATE Member m set m.password = :password where m.id = :id")
    Member UpdatePassword(Long id, Object password);

    @Modifying
    @Query("UPDATE Member m set m.address = :address where m.id = :id")
    Member UpdateAddress(Long id, Object address);



}
