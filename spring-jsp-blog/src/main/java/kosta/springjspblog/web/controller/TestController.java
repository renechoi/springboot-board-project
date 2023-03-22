package kosta.springjspblog.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class TestController {

    @PostMapping("/test/1")
    public String test(@RequestBody ReqTest reqTest){

        System.out.println("reqTest = " + reqTest);
        return "board/article-list";
    }
}
