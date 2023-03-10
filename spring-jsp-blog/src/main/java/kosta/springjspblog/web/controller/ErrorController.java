package kosta.springjspblog.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@Controller
public class ErrorController {
	
	/*JBlog 메인 폼 출력*/
	@GetMapping(value="/error")
	public String Error(Model model) {
		return "error/403";
	}



	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public String handle404(NoHandlerFoundException ex, Model model) {
		log.error("404 요청 발생", ex.getRequestURL());
		model.addAttribute("msg", "그런 페이지는 없어요.");
		return "error/403";
	}
}
