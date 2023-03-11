package kosta.springjspblog.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class CustomErrorController implements ErrorController {

    public static final String ERROR_NOT_FOUND = String.valueOf(HttpStatus.NOT_FOUND.value());
    public static final String ERROR_BAD_REQUEST = String.valueOf(HttpStatus.BAD_REQUEST.value());
    public static final String ERROR_FORBIDDEN = String.valueOf(HttpStatus.FORBIDDEN.value());
    public static final String ERROR_NO_CONTENT = String.valueOf(HttpStatus.NO_CONTENT.value());

//    @ExceptionHandler(NoHandlerFoundException.class)
//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    public String handle404(NoHandlerFoundException ex, Model model) {
//        System.out.println("CustomErrorController.handle404");
//        log.error("400 요청 발생", ex.getRequestURL());
//        model.addAttribute("msg", "그런 페이지는 없어요.");
//        return "error/403";
//    }

    @RequestMapping(value = "/error")
    public String error(HttpServletRequest request) {
        String statusCode = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
        if (statusCode.equalsIgnoreCase(ERROR_FORBIDDEN)) {
            return "error/403";
        }
        if (statusCode.equalsIgnoreCase(ERROR_NOT_FOUND)) {
            return "error/404";
        }
        if (statusCode.equalsIgnoreCase(ERROR_NO_CONTENT)) {
            return "error/no-content";
        }
        return "error/400";
    }
}
