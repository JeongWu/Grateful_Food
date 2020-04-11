package com.example.demo.web.Controller;

import com.example.demo.config.auth.dto.SessionUser;
import com.example.demo.domain.Store;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.StoreRepository;
import com.example.demo.service.CategoryService;

import com.example.demo.service.FoodService;
import com.example.demo.service.OrderService;
import com.example.demo.service.StoreService;
import com.example.demo.web.Response.StoreListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final CategoryService categoryService;

    private final HttpSession httpSession;
    private final CommentRepository commentRepository;
    private final OrderRepository orderRepository;
    private final FoodService foodService;
    private final StoreService storeService;


    @GetMapping("/")
    public String index(Model model) {

        /**
         * List 형태반환
         */
        model.addAttribute("category", categoryService.findAllDesc());


        //CustomOAuth2UserService에서 로그인 성공시 세션에 SessionUser를 저장하도록 구성함.
        //즉 로그인 성공시 httpSession.getAttribute("user")에서 값을 가져올수 있다.

        SessionUser user = (SessionUser) httpSession.getAttribute("user"); //세션값을 가져오는 부분

        if (user != null) { // 세션에 저장된 값이 있을때만 model에 userName으로 등록한다.
            //세션에 저장된 값이 없으면 model엔 아무런 값이 없는 상태이니 로그인 버튼이 보인다.
            model.addAttribute("userName", user.getName());
        }

        return "MainContent"; //index.mustache로 자동 변환되어 반환한다.
    }

    /**
     * 치킨 카테고리
     */
    @GetMapping("/chickin")
    public String postsCheckin(Model model){
        Store store = new Store();

        model.addAttribute("Store", storeService.findAllCheckin());
        return "chickin";
    }

    /**
     * 족발 카테고리
     */
    @GetMapping("/zokbal")
    public String postsPig(Model model){
        model.addAttribute("Store", storeService.findAllZokbal());
        return "zokbal";
    }

    /**
     * 피자 카테고리
     */
    @GetMapping("/pizza")
    public String postsPizza(Model model){

        model.addAttribute("Store", storeService.findAllPizza());
        return "pizza";
    }

    /**
     * 한식카테고리
     */
    @GetMapping("/korea")
    public String postsKorea(Model model){

        model.addAttribute("Store", storeService.findAllKorea());
        return "korea";
    }


    /**
     *
     * @param complete
     * @return
     */

    @GetMapping("/chickin/kfc")
    public String foodKkc(Model model){

        model.addAttribute("kfc-1", foodService.findOne("파닭치킨"));
        model.addAttribute("kfc-2", foodService.findOne("초콜릿치킨"));


        return "kfc";
    }

    @GetMapping("/chickin/bbq")
    public String foodBbq(Model model){
        model.addAttribute("bbq-1", foodService.findOne("후라이드"));
        return "bbq";
    }

    @GetMapping("/pizza/pizzahut")
    public String foodDomino(Model model){
        model.addAttribute("pizzahut-1", foodService.findOne("고구마피자"));
        return "pizzahut";
    }

    @GetMapping("/pizza/domino")
    public String foodPizzahut(Model model){
        model.addAttribute("domino-1", foodService.findOne("도미노특제소스피자"));
        return "Domino";
    }

    @GetMapping("/korea/heaven")
    public String foodHeaven(Model model){
        model.addAttribute("heaven-1", foodService.findOne("메로나김밥"));
        return "heavn";
    }

    @GetMapping("/korea/hell")
    public String foodHell(Model model){
        model.addAttribute("hell-1", foodService.findOne("랍스타김밥"));
        return "hell";
    }

    @GetMapping("/zokbal/hyeonwoo")
    public String foodHyeonwoo(Model model){
        model.addAttribute("hyeonwoo-1", foodService.findOne("매운족발"));
        model.addAttribute("hyeonwoo-2", foodService.findOne("덜매운족발"));

        return "hyeonwoo";
    }

    @GetMapping("/zookbal/gazok")
    public String foodGazok(Model model){
        model.addAttribute("gazok-1", foodService.findOne("마늘족발"));

        return "gazok";
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
    public String CommentUser(Model model) {

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