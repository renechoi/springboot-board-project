package kosta.boot.board.web.controller;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.Board;
import kosta.boot.board.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/board")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @Trace
    @GetMapping(value="/register")
    public String register(){
        return "board/list";
    }

    @Trace
    @PostMapping(value = "/register")
    public String register(final Board params) {
        try {
            articleService.register(params);
        } catch (DataAccessException e) {
            // TODO => 데이터베이스 처리 과정에 문제가 발생하였다는 메시지를 전달
        } catch (Exception e) {
            // TODO => 시스템에 문제가 발생하였다는 메시지를 전달
        }

        return "redirect:/board/list";
    }
}
