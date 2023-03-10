package kosta.springjspblog.web.api;


import kosta.springjspblog.domain.dto.Category;
import kosta.springjspblog.domain.dto.User;
import kosta.springjspblog.domain.service.CategoryService;
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
        User authUser = (User) session.getAttribute("authUser");
        return categoryService.getCategories(authUser.getId());
    }

    /*카테고리 추가*/
    @ResponseBody
    @PostMapping(value = "/add")
    public Category cateAdd(@ModelAttribute Category category, HttpSession session) {
        User authUser = (User) session.getAttribute("authUser");
        category.setUserId(authUser.getId());
        return categoryService.add(category);
    }

    /*카테고리 삭제*/
    @ResponseBody
    @PostMapping(value = "/remove")
    public int categoryRemove(@RequestParam("categoryNo") int categoryNo) {
        System.out.println("CategoryController.cateAdd");
        int result = categoryService.delete(categoryNo);
        System.out.println("result = " + result);
        return result;
    }


}
