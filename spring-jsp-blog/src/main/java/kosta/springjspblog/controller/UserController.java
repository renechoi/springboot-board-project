package kosta.springjspblog.controller;

import kosta.springjspblog.service.UserService;
import kosta.springjspblog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	/*회원가입폼 출력*/
	@GetMapping(value = "/join")
	public String joinForm() {
		return "user/joinForm";
	}

	/*회원가입*/
	@PostMapping(value = "/join")
	public String join(@ModelAttribute User user) {
		// userName, id, password
		userService.join(user);
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
		if (authUser != null) { //성공시
			session.setAttribute("authUser", authUser);
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
	@PostMapping(value = "/idcheck")
	public boolean cateList(String id) {
		return userService.idCheck(id);
	}

}

