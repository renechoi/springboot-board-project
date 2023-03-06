package kosta.springjspblog.controller;

import kosta.springjspblog.domain.Article;
import kosta.springjspblog.domain.Blog;
import kosta.springjspblog.domain.Category;
import kosta.springjspblog.domain.User;
import kosta.springjspblog.service.ArticleService;
import kosta.springjspblog.service.BlogService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import kosta.springjspblog.service.CategoryService;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

    private final CategoryService categoryService;
    //
    private final ArticleService articleService;

    @GetMapping(value = "/{id}/create")
    public String createForm() {
        return "blog/blog-createForm";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, HttpSession session) {
        User user = (User) session.getAttribute("authUser");

        if (blog != null) { //성공시
//            blog.setId(user.getId());
            blog.setUserId(user.getId());
            session.setAttribute("blog", blog);
            Blog createdBlog = blogService.create(blog);
            return "blog/blog-main";
        }
        return "redirect:/result=fail";
    }

    @GetMapping(value = "/{id}")
    public String myBlog(@PathVariable("id") String id,
                         @RequestParam(value = "categoryNo", defaultValue = "0") int categoryNo,
                         @RequestParam(value = "articleNo", defaultValue = "0") int articleNo,
                         HttpSession session, Model model) {

        System.out.println("BlogController.myBlog");


        Blog blog = blogService.getBlog(id);
        String userId = blog.getUserId();
        List<Category> categories = categoryService.getCategories(userId);
        List<Article> articles = articleService.getArticles(userId, categoryNo);
        int articlesSize = Optional.ofNullable(articles).map(List::size).orElse(0);

        if (articleNo == 0 && articlesSize != 0) {//postNo == 0  파라미터에서 넘어온 값이 없을때
            articleNo = articleAtFirst(articles).getArticleNo();
        }

        Article article = articleService.getArticle(articleNo);

        System.out.println("article = " + article);

        log.info("blog = {}", blog);
        log.info("article = {}", article);
        log.info("categories = {}", categories);

        model.addAttribute("blogVo", blog);
        model.addAttribute("cateList", categories);
        model.addAttribute("postList", articles);
        model.addAttribute("postVo", article);
        model.addAttribute("newLine", "\r\n");
        return "blog/blog-main";
    }

    private static Article articleAtFirst(List<Article> articles) {
        return articles.get(0);
    }

    /*개인블로그 기본설정페이지 출력*/
    @GetMapping(value = "/{id}/admin/basic")
    public String blogAdminBasic(@PathVariable("id") String id, HttpSession session, Model model) {

        User authUser = (User) session.getAttribute("authUser");

        System.out.println("authUser = " + authUser);
        //로그인했고 자신의 블로그이면 진행
        if (isLoginAndProperUser(id, authUser)) {
            //블로그 기본정보 가져오기
            Blog blog = blogService.getBlog(id);
            model.addAttribute("blogVo", blog);
            return "blog/admin/blog-admin-basic";

        } else { //타인의 블로그 설정페이지로 진입 시도한 경우

            return "error/403";
        }
    }

    /*개인블로그 기본설정페이지 수정*/
    @PostMapping(value = "/{id}/admin/basicModify")
    public String blogAdminBasicModify(@ModelAttribute Blog blog, HttpSession session, Model model) {

        User authUser = (User) session.getAttribute("authUser");
        //로그인했고 자신의 블로그이면 진행
        if (isLoginAndProperUser(authUser.getId(), authUser)) {
            blog.setUserId(authUser.getId());

            blogService.blogAdminBasicModify(blog);
            return "redirect:/" + "blog/" + blog.getUserId() + "/admin/basic";
        }
        return "error/403";
    }

    /*개인블로그 카테고리설정 페이지 출력*/
    /*등록 수정은 ajax로 api 컨트롤러 참고*/
    @GetMapping(value = "/{id}/admin/category")
    public String blogAdminCate(@PathVariable("id") String id, HttpSession session, Model model) {
        User authUser = (User) session.getAttribute("authUser");

        //로그인했고 자신의 블로그이면 진행
        if (isLoginAndProperUser(id, authUser)) {
            //블로그 기본정보 가져오기
            Blog blog = blogService.getBlog(id);

            /*카테고리정보 가져오기*/
            List<Category> categories = categoryService.getCategories(blog.getUserId());

            model.addAttribute("blogVo", blog);
            model.addAttribute("cateList", categories);
            return "/blog/admin/blog-admin-category";

        } else { //타인의 블로그 설정페이지로 진입 시도한 경우
            return "error/403";
        }
    }

    private static boolean isLoginAndProperUser(String id, User authUser) {
        return authUser != null && id.equals(authUser.getId());
    }


    /*개인블로그 글쓰기설정페이지 출력*/
    @GetMapping(value = "/{id}/admin/write")
    public String blogAdminWrite(@PathVariable("id") String id, HttpSession session, Model model) {
        User authUser = (User) session.getAttribute("authUser");
        System.out.println(authUser);
        System.out.println("id : " + id);
        System.out.println("authUser.getId() : " + authUser.getId());

        //로그인했고 자신의 블로그이면 진행
        if (isLoginAndProperUser(id, authUser)) {
            //블로그 기본정보 가져오기
            Blog blog = blogService.getBlog(id);

            //카테고리 정보 가져오기 (셀렉트박스 출력용)
            List<Category> cateList = categoryService.getCategories(blog.getUserId());

            model.addAttribute("blogVo", blog);
            model.addAttribute("cateList", cateList);
            return "blog/admin/blog-admin-write";

        } else { //로그인 안했으면 로그인 페이지로
            return "error/403";
        }

    }

    /*개인블로그 글쓰기설정페이지 저장*/
    @PostMapping(value = "/{id}/admin/write")
    public String blogAdminWritePost(@PathVariable("id") String id, @ModelAttribute Article article, HttpSession session, Model model) {
        User authUser = (User) session.getAttribute("authUser");
        System.out.println(authUser);
        System.out.println("id : " + id);
        System.out.println("authUser.getId() : " + authUser.getId());

        log.info("article = {} ", article);

        //로그인했고 자신의 블로그이면 진행
        if (isLoginAndProperUser(id, authUser)) {
            //포스트 글저장
            articleService.Write(article);
        } else { //로그인 안했으면 로그인 페이지로
            return "error/403";
        }
        //return "error/403";
        //return "redirect:/blog/blog-main";

        return "redirect:/" + "blog/" + id;
    }


}
