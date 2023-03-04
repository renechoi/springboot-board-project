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

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {

    private final BlogService blogService;

//	private final CateService cateService;
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
            blog.setId(user.getId());
            session.setAttribute("blog", blog);
            blogService.create(blog);
            return "blog/blog-main";
        }
        return "redirect:/result=fail";
    }

	@GetMapping(value="/{id}")
	public String myBlog(@PathVariable("id") String id,
                         @RequestParam(value="crtCateNo", defaultValue="0") int crtCateNo,
                         @RequestParam(value= "articleNo", defaultValue="0") int articleNo,
                         HttpSession session, Model model) {

		System.out.println("BlogController.myBlog");

		//방문한 블로그정보
		Blog blog = blogService.getBlog(id);
		System.out.println(blog);

		//방문한 블로그의 회원정보 구하기
		int userNo = blog.getUserNo();
//
//		//방문한 블로그의 카테고리정보
//		List<Category> cateList = cateService.getCateList(userNo);
//
//		//포스트리스트  기본값 전체, 선택한 카테고리 (crtCateNo) 리스트가져오기, 선택한 카테고리 없으면 전체리스트 가져오기
		List<Article> articles = articleService.getArticles(userNo, crtCateNo);
        int articlesSize  = Optional.ofNullable(articles).map(List::size).orElse(0);

		//선택한 포스트 글 출력하기
		if( articleNo == 0 && articlesSize != 0  ) {//postNo == 0  파라미터에서 넘어온 값이 없을때
			                                        //postList.size() != 0 출력된 리스트가 1개이상일때
			//맨앞의 글 번호 가져옴
			articleNo = articleAtFirst(articles).getArticleNo();
		}
		//파라미터로 넘어온 경우에는 넘어온 번호(선택한 포스트번호)
		//그이외에는 맨앞의 글번호
		//로 포스트를 가져옴
		Article article = articleService.getArticle(articleNo);

		model.addAttribute("blogVo", blog);
//		model.addAttribute("cateList", cateList);
		model.addAttribute("postList", articles);
		model.addAttribute("postVo", article);
		model.addAttribute("newLine", "\r\n"); //줄바꾸기용
		return "blog/blog-main";
	}

    private static Article articleAtFirst(List<Article> articles) {
        return articles.get(0);
    }

	/*개인블로그 기본설정페이지 출력*/
	@GetMapping(value="/{id}/admin/basic")
	public String blogAdminBasic(@PathVariable("id") String id, HttpSession session, Model model) {

		User authUser = (User)session.getAttribute("authUser");

        System.out.println("authUser = " + authUser);
		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && id.equals(authUser.getId())) {
			//블로그 기본정보 가져오기
			Blog blog = blogService.getBlog(id);
			model.addAttribute("blogVo", blog);
			return "blog/admin/blog-admin-basic";

		} else { //타인의 블로그 설정페이지로 진입 시도한 경우

			return "error/403";
		}
	}


	/*개인블로그 기본설정페이지 수정*/
	@GetMapping(value="/{id}/admin/basicModify")
	public String blogAdminBasicModify(@ModelAttribute Blog blog, HttpSession session, Model model) {

	  //System.out.println("pid[" + pid +"]");

		String id = blog.getId();
		System.out.println("id [" + id +"]");
		User authUser = (User)session.getAttribute("authUser");

		//로그인했고 자신의 블로그이면 진행
		if( authUser != null && id.equals(authUser.getId())) {
			blog.setUserNo(authUser.getUserNo());

			//System.out.println(blogVo);

			//기본설정 수정
			blogService.blogAdminBasicModify(blog);
			return "redirect:/" + blog.getId() + "/admin/basic";

		} else { //타인의 블로그 설정페이지 수정을 시도한 경우
			return "error/403";
		}
	}



//	/*개인블로그 카테고리설정 페이지 출력*/
//	/*등록 수정은 ajax로 api 컨트롤러 참고*/
//	@RequestMapping(value="/{id}/admin/category", method=RequestMethod.GET)
//	public String blogAdminCate(@PathVariable("id") String id, HttpSession session, Model model) {
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//
//		//로그인했고 자신의 블로그이면 진행
//		if( authUser != null && id.equals(authUser.getId())) {
//			//블로그 기본정보 가져오기
//			BlogVo blogVo = blogService.getBlog(id);
//
//			/*카테고리정보 가져오기*/
//			List<CateVo> cateList = cateService.getCateList(blogVo.getUserNo());
//
//			model.addAttribute("blogVo", blogVo);
//			model.addAttribute("cateList", cateList);
//			return "blog/admin/blog-admin-cate";
//
//		}else { //타인의 블로그 설정페이지로 진입 시도한 경우
//			return "error/403";
//		}
//
//	}
//
//
//	/*개인블로그 글쓰기설정페이지 출력*/
//	@RequestMapping(value="/{id}/admin/write", method=RequestMethod.GET)
//	public String blogAdminWrite(@PathVariable("id") String id, HttpSession session, Model model) {
//		User authUser = (User)session.getAttribute("authUser");
//		System.out.println(authUser);
//		System.out.println("id : " + id);
//		System.out.println("authUser.getId() : " + authUser.getId());
//
//		//로그인했고 자신의 블로그이면 진행
//		if( authUser != null && id.equals(authUser.getId())) {
//			//블로그 기본정보 가져오기
//			Blog blogVo = blogService.getBlog(id);
//
//			//카테고리 정보 가져오기 (셀렉트박스 출력용)
//			List<Category> cateList = cateService.getCateList(blogVo.getUserNo());
//
//			model.addAttribute("blogVo", blogVo);
//			model.addAttribute("cateList", cateList);
//			return "blog/admin/blog-admin-write";
//
//		}else { //로그인 안했으면 로그인 페이지로
//			return "error/403";
//		}
//
//	}
//
//	/*개인블로그 글쓰기설정페이지 저장*/
//	@RequestMapping(value="/{id}/admin/write", method=RequestMethod.POST)
//	public String blogAdminWritePost(@PathVariable("id") String id, @ModelAttribute PostVo postVo, HttpSession session, Model model) {
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		System.out.println(authUser);
//    System.out.println("id : " + id);
//    System.out.println("authUser.getId() : " + authUser.getId());
//
//		//로그인했고 자신의 블로그이면 진행
//		if( authUser != null && id.equals(authUser.getId())) {
//			//포스트 글저장
//			postService.postWrite(postVo);
//		}else { //로그인 안했으면 로그인 페이지로
//			return "error/403";
//		}
//		//return "error/403";
//		//return "redirect:/blog/blog-main";
//
//		return "redirect:/" + id;
//	}


}
