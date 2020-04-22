package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface MemberRepository extends JpaRepository<Member, Long> {

    /**
     *
     * @param email
     * @return 이미 회원가입 된 사람 입니다.
     */
    @Query("SELECT m FROM Member m where m.email =  :email")
    Member findEmailCheck(String email);

    /**
     *
     * @param id
     * return 회원찾기
     */
    @Query("SELECT m FROM Member m where m.id = :id")
    Member findOne(Long id);

    /**
     *
     * @param email
     * @param password
     * @return 아이디와 이메일을 확인해주세요
     */
    @Query("SELECT m FROM Member m where m.email = :email AND m.password = :password")
    Member findByEmailPassword(Object email, Object password);


//    @Modifying
//    @Query("UPDATE Member m set m.address = :address where m.id = :id")
//    Member UpdateAddress(Long id, Object address);

    /**
     *
     * @param email
     * @return 구글계정변경
     */
    Optional<Member> findByEmail(String email);



}
