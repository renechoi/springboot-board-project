package kosta.springjspblog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	
	/*JBlog 메인 폼 출력*/
	@GetMapping(value="/")
	public String main(Model model) {
		return "main/index";
//		return "resources/templates/main/index.html";
	}
}
