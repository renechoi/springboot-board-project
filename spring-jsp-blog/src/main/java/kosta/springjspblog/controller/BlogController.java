//package kosta.springjspblog.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import com.javaex.service.BlogService;
//import com.javaex.service.CateService;
//import com.javaex.service.PostService;
//import com.javaex.vo.BlogVo;
//import com.javaex.vo.CateVo;
//import com.javaex.vo.PostVo;
//import com.javaex.vo.UserVo;
//
//@Controller
//public class BlogController {
//
//	@Autowired
//	private BlogService blogService;
//
//	@Autowired
//	private CateService cateService;
//
//	@Autowired
//	private PostService postService;
//
//	/*개인블로그 메인페이지*/
//	@RequestMapping(value="/{id}", method=RequestMethod.GET)
//	public String blogMain(@PathVariable("id") String id,
//			               @RequestParam(value="crtCateNo", required=false, defaultValue="0") int crtCateNo,
//			               @RequestParam(value="postNo", required=false, defaultValue="0") int postNo,
//			               HttpSession session, Model model) {
//
//		//방문한 블로그정보
//		BlogVo blogVo = blogService.getBlog(id);
//
//		System.out.println(blogVo);
//
//		//방문한 블로그의 회원정보 구하기
//		int userNo = blogVo.getUserNo();
//
//
//		//방문한 블로그의 카테고리정보
//		List<CateVo> cateList = cateService.getCateList(userNo);
//
//
//		//포스트리스트  기본값 전체, 선택한 카테고리 (crtCateNo) 리스트가져오기, 선택한 카테고리 없으면 전체리스트 가져오기
//		List<PostVo> postList = postService.getPostList(userNo, crtCateNo);
//
//		System.out.println("postNo " + postNo);
//		//선택한 포스트 글 출력하기
//		if( postNo == 0 && postList.size() != 0  ) {//postNo == 0  파라미터에서 넘어온 값이 없을때
//			                                        //postList.size() != 0 출력된 리스트가 1개이상일때
//			//맨앞의 글 번호 가져옴
//			postNo = postList.get(0).getPostNo();
//		}
//		//파라미터로 넘어온 경우에는 넘어온 번호(선택한 포스트번호)
//		//그이외에는 맨앞의 글번호
//		//로 포스트를 가져옴
//		PostVo postVo = postService.getPost(postNo);
//
//		model.addAttribute("blogVo", blogVo);
//		model.addAttribute("cateList", cateList);
//		model.addAttribute("postList", postList);
//		model.addAttribute("postVo", postVo);
//		model.addAttribute("newLine", "\r\n"); //줄바꾸기용
//		return "blog/blog-main";
//	}
//
//
//	/*개인블로그 기본설정페이지 출력*/
//	@RequestMapping(value="/{id}/admin/basic", method=RequestMethod.GET)
//	public String blogAdminBasic(@PathVariable("id") String id, HttpSession session, Model model) {
//
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//
//		//로그인했고 자신의 블로그이면 진행
//		if( authUser != null && id.equals(authUser.getId())) {
//			//블로그 기본정보 가져오기
//			BlogVo blogVo = blogService.getBlog(id);
//			model.addAttribute("blogVo", blogVo);
//			return "blog/admin/blog-admin-basic";
//
//		} else { //타인의 블로그 설정페이지로 진입 시도한 경우
//			return "error/403";
//		}
//
//	}
//
//
//	/*개인블로그 기본설정페이지 수정*/
//	@RequestMapping(value="/{id}/admin/basicModify", method=RequestMethod.POST)
//	public String blogAdminBasicModify(@ModelAttribute BlogVo blogVo, HttpSession session, Model model) {
//
//	  //System.out.println("pid[" + pid +"]");
//
//		String id = blogVo.getId();
//
//		System.out.println("id[" + id +"]");
//
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//
//		//로그인했고 자신의 블로그이면 진행
//		if( authUser != null && id.equals(authUser.getId())) {
//			blogVo.setUserNo(authUser.getUserNo());
//
//			//System.out.println(blogVo);
//
//			//기본설정 수정
//			blogService.blogAdminBasicModify(blogVo);
//			return "redirect:/" + blogVo.getId() + "/admin/basic";
//
//		} else { //타인의 블로그 설정페이지 수정을 시도한 경우
//			return "error/403";
//		}
//	}
//
//	/*개인블로그 카테고리설정 페이지 출력*/
//	/*등록 수정은 ajax로 api 컨트롤러 참고*/
//	@RequestMapping(value="/{id}/admin/cate", method=RequestMethod.GET)
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
//		UserVo authUser = (UserVo)session.getAttribute("authUser");
//		System.out.println(authUser);
//		System.out.println("id : " + id);
//		System.out.println("authUser.getId() : " + authUser.getId());
//
//		//로그인했고 자신의 블로그이면 진행
//		if( authUser != null && id.equals(authUser.getId())) {
//			//블로그 기본정보 가져오기
//			BlogVo blogVo = blogService.getBlog(id);
//
//			//카테고리 정보 가져오기 (셀렉트박스 출력용)
//			List<CateVo> cateList = cateService.getCateList(blogVo.getUserNo());
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
//
//
//}
