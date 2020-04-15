package com.example.demo.service;



import com.example.demo.domain.Member;
import com.example.demo.repository.FoodRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.web.Request.CommentSaveRequestDto;
import com.example.demo.web.Request.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    //회원가입
    public Member SingUp(MemberSaveRequestDto requestDto) {
        String result= validateDuplicateMember(requestDto);
        if(result =="OK") {
            return memberRepository.save(requestDto.toEntity());

        }else {
            return null;
        }
    }

    //회원가입 아이디 중복체크
    @Transactional
    private String validateDuplicateMember(MemberSaveRequestDto requestDto) {
        List<Member> findMembers = memberRepository.findByEmail(requestDto.getEmail());
        if (!findMembers.isEmpty()) {
//            throw new IllegalStateException("회원가입된 사람입니다.");
            return "NO";
        }
        return "OK";
    }

    //아이디 패스워드 확인
    @Transactional
    public String check_login(Object email, Object password){
        Member member = memberRepository.findByEmailPassword(email, password);
        if (member == null) {
//            throw new IllegalStateException("아이디와 비밀번호를 다시 확인해 주세요.");
            return "NO";
        }

        return "YES";
    }


//    //정보 수정
//    @Transactional
//    public String check_login(Object email, Object password){
//        Member member = memberRepository.findByEmailPassword(email, password);
//        if (member == null) {
////            throw new IllegalStateException("아이디와 비밀번호를 다시 확인해 주세요.");
//            return "NO";
//        }
//
//        return "YES";
//    }








    @Transactional(readOnly =  true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    @Transactional(readOnly =  true)
    public Member findOne(Long memberId) {

        return memberRepository.findOne(memberId);
    }


}
