package kosta.boot.board.web.controller;

import kosta.boot.board.config.annotation.Trace;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Trace
    @RequestMapping("/")
    public String main(){
        return "write-form";
    }
}
