package kosta.springjspblog.web.controller;

import kosta.springjspblog.domain.dto.Blog;
import kosta.springjspblog.domain.service.BlogService;
import kosta.springjspblog.domain.service.UserService;
import kosta.springjspblog.domain.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
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
	public String join(@ModelAttribute User user) {
		userService.join(user);
		return "user/joinSuccess";
	}

	@GetMapping(value = "/login")
	public String loginForm() {
		return "user/loginForm";
	}

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

	@GetMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping(value = "/{id}/unregister")
	public String unRegisterForm() {
		return "blog/admin/blog-admin-unregister";
	}

	@PostMapping(value = "/{id}/unregister")
	public String unRegister(@ModelAttribute User user, HttpSession session) {
		userService.unRegister(user, session);
		return "redirect:/";
	}
}

