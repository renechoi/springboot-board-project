package kosta.boot.board.web.controller;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @Trace
    @GetMapping(value = "/register")
    public String register() {
        return "board/list";
    }

    @Trace
    @PostMapping(value = "/register")
    public String register(final ArticleDto articleDto) {
//        log.info("articleDto = {}", articleDto);
        boolean result = articleService.register(articleDto);
//        log.info("register result = {}", result);
        return "redirect:/board/list";
    }


    @GetMapping(value = "/write")
    public String writeForm(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        ArticleDto articleDto = articleService.findByIdx(idx);
        model.addAttribute("article", articleDto);
        return "board/write-form";
    }

}
