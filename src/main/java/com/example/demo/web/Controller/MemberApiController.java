package com.example.demo.web.Controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import com.example.demo.web.Request.MemberSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;


@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;
    private final HttpSession httpSession;

    //회원가입
    @PostMapping("/guest/singup")
    public String Join(@RequestBody MemberSaveRequestDto requestDto, HttpServletRequest request) {
        Member member = memberService.SingUp(requestDto);
        if (member == null) {
            return "NO";
        } else {
            return "YES";
        }
    }

    //사장님 회원가입
    @PostMapping("/chairman/singup")
    public String Join_User(@RequestBody MemberSaveRequestDto requestDto, HttpServletRequest request) {
        Member member = memberService.SingUp(requestDto);
        if (member == null) {
            return "NO";
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("member", member);

            return "YES";
        }
    }

    //비밀번호 아이디 체크 후 로그인
    @ResponseBody
    @RequestMapping("/login") //ajax
    public String check_id(@RequestBody HashMap<String, Object> map) {
        String result = memberService.Check_Login(map.get("name"), map.get("password"));
        return result;
    }

    //로그아웃
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession();

        session.invalidate();
//        return"redirect:/";
    }
}
//    정보 수정
//    public String modify(int password, String name, HttpServletRequest request) {
//
//        HttpSession session = request.getSession();


//    }


