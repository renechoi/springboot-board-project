package kosta.boot.board.web.controller;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.config.utils.UiUtils;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/article")
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @Trace
    @GetMapping(value = "/register")
    public String register() {
        return "/board/article-list";
    }

    @Trace
    @PostMapping(value = "/register")
    public String register(final ArticleDto articleDto, Model model) {
        boolean result = articleService.register(articleDto);
        return result ?
                UiUtils
                .showMessageWithRedirect("게시글 등록이 완료되었습니다.", "/article/list", HttpMethod.GET, null, model)
                .forward() :
                UiUtils
                .showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/article/list", HttpMethod.GET, null, model)
                .forward();
    }


    @GetMapping(value = "/write")
    public String writeForm(@RequestParam(value = "idx", required = false) Long idx, Model model) {
        ArticleDto articleDto = articleService.findByIdx(idx);
        model.addAttribute("article", articleDto);
        return "board/write-form";
    }


    @GetMapping(value = "/list")
    public String getArticles(Model model) {
        List<ArticleDto> articles = articleService.findAll(null);
        model.addAttribute("articles", articles);
        return "board/article-list";
    }


    @GetMapping(value = "/view")
    public String openBoardDetail(@RequestParam(value = "idx", required = false) Long idx, Model model) {

        ArticleDto articleDto = articleService.findByIdx(idx);
        if (articleDto == null || "Y".equals(articleDto.getDeletedYn())) {
            // TODO => 없는 게시글이거나, 이미 삭제된 게시글이라는 메시지를 전달하고, 게시글 리스트로 리다이렉트
            return "redirect:/article/list";
        }
        model.addAttribute("article", articleDto);
        return "board/article";
    }


    @PostMapping(value = "/delete")
    public String deleteBoard(@RequestParam(value = "idx", required = false) Long idx) {
        boolean isDeleted = articleService.delete(idx);
        return "redirect:/article/list";
    }


}


