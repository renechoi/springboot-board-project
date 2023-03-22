package kosta.springjspblog.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @PostMapping("/test/2")
    public String test(@RequestBody ReqTest reqTest){

        System.out.println("reqTest = " + reqTest);
        return "board/article-list";
    }
}
