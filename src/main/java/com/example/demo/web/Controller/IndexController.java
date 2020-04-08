package com.example.demo.web.Controller;

import com.example.demo.config.auth.dto.SessionUser;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.FoodService;

import com.example.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final FoodService foodService;

    private final HttpSession httpSession;

    private final CommentRepository commentRepository;
    private final OrderRepository orderRepository;
    private final StoreRepository storeRepository;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("food", foodService.findAllDesc());


        //CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성함.
        //즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올수 있다.

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분

        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
        }

        return "index"; //index.mustache로 자동 변환되어 반환한다.
    }

    /**
     * 치킨 카테고리
     */
    @GetMapping("/chickin")
    public String postsCheckin(Model model){
//        model.addAttribute("Store", storeRepository.findAll_chicken());
        return "chickin";
    }

    /**
     * 족발 카테고리
     */
    @GetMapping("/zokbal")
    public String postsPig(Model model){
//        model.addAttribute("Store", storeRepository.findAll_zokbal());
        return "zokbal";
    }

    /**
     * 피자 카테고리
     */
    @GetMapping("/pizza")
    public String postsPizza(Model model){

//        model.addAttribute("Store", storeRepository.findAll_pizza());
        return "pizza";
    }

    /**
     * 한식카테고리
     */
    @GetMapping("/korea")
    public String postsKorea(Model model){

//        model.addAttribute("Store", storeRepository.findAll_korea());
        return "korea";
    }


    @GetMapping("posts/mydata") //내 정보 + 주문목록
    public String postsMyData(Model model) {

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분
        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
            model.addAttribute("userEmail", user.getEmail());
            model.addAttribute("userPicture", user.getPicture());
        }
        model.addAttribute("Order", orderRepository.findAll()); //food정보를 보여줌

        return "mydata-page";
    }




    /**
     *
     * @param 모든댓글
     * 사장 / 고객 모든댓글을보여준다.
     */
    @GetMapping("/posts/comment")
    public String CommentSaveUser(Model model) {

        model.addAttribute("Comment", commentRepository.findAll());
        return "comment";
    }


    //배송을 알리는 관리자 페이지
    @GetMapping("/posts/chairman")
    public String postsChairman() {
        return "chairman";
    }

    //수량 취소 + 추가
    @GetMapping("/posts/add")
    public String BasketAddCancle() { return "order";}

}