package kosta.springjspblog.web.api;


import kosta.springjspblog.domain.dto.Category;
import kosta.springjspblog.domain.dto.User;
import kosta.springjspblog.domain.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
public class CategoryRestController {

    private final CategoryService categoryService;

    @ResponseBody
    @PostMapping(value = "/list")
    public List<Category> cateList(HttpSession session) {
        User authUser = (User) session.getAttribute("authUser");
        return categoryService.getCategories(authUser.getId());
    }

    @ResponseBody
    @PostMapping(value = "/add")
    public Category cateAdd(@ModelAttribute Category category, HttpSession session) {
        User authUser = (User) session.getAttribute("authUser");
        category.setUserId(authUser.getId());
        return categoryService.add(category);
    }

    @ResponseBody
    @PostMapping(value = "/remove")
    public int categoryRemove(@ModelAttribute Category category) {
        return categoryService.delete(category);
    }
}
