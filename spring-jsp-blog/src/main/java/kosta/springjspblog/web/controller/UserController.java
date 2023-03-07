package kosta.springjspblog.web.controller;

import kosta.springjspblog.domain.dto.Blog;
import kosta.springjspblog.domain.service.BlogService;
import kosta.springjspblog.domain.service.UserService;
import kosta.springjspblog.domain.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	private final BlogService blogService;

	@GetMapping(value = "/join")
	public String joinForm() {
		return "user/joinForm";
	}

	@PostMapping(value = "/join")
	public String join(@ModelAttribute User user, HttpSession session) {
		// userName, id, password
		userService.join(user, session);
		return "user/joinSuccess";
	}

	/*로그인폼 출력*/
	@GetMapping(value = "/login")
	public String loginForm() {
		return "user/loginForm";
	}

	/*로그인*/
	@PostMapping(value = "/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		User authUser = userService.login(user);
		Blog blog = blogService.getBlog(user.getId());

		if (authUser != null) {
			session.setAttribute("authUser", authUser);
			session.setAttribute("blog", blog);
			return "redirect:/";
		}
		return "redirect:/user/login?result=fail";
	}

	/*로그아웃*/
	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}

	@ResponseBody
	@PostMapping(value = "/idCheck")
	public boolean cateList(String id) {
		return userService.idCheck(id);
	}

}

