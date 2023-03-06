package kosta.springjspblog.api;


import kosta.springjspblog.domain.Category;
import kosta.springjspblog.domain.User;
import kosta.springjspblog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    /*회원별(블로그별) 카테고리 리스트 가져오기*/
    @ResponseBody
    @PostMapping(value = "/list")
    public List<Category> cateList(HttpSession session) {
        //로그인한 사용자의 카테고리 리스트를 가져옴
        User authUser = (User) session.getAttribute("authUser");
        return categoryService.getCategories(authUser.getUserNo());
    }

    /*카테고리 추가*/
    @ResponseBody
    @PostMapping(value = "/add")
    public Category cateAdd(@ModelAttribute Category category) {
        //카테고리 내용을 저장하고 방금저장한 카테고리 정보 모두를 가져온다
        return categoryService.add(category);
    }

    /*카테고리 삭제*/
    @ResponseBody
    @PostMapping(value = "/remove")
    public int cateAdd(@RequestParam("cateNo") int cateNo) {
        return categoryService.delete(cateNo);
    }

}
