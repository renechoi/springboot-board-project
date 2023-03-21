package kosta.boot.board.web.controller;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import kosta.boot.board.config.adapter.GsonLocalDateTimeAdapter;
import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @Trace
    @GetMapping(value = "/{articleIdx}")
    public JsonObject getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) {

        System.out.println("articleIdx = " + articleIdx);
        System.out.println("commentDto = " + commentDto);

        List<CommentDto> comments = commentService.findAll(commentDto);

        JsonObject jsonObj = new JsonObject();

        if (!CollectionUtils.isEmpty(comments)) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();
            JsonArray jsonArr = gson.toJsonTree(comments).getAsJsonArray();
            jsonObj.add("comments", jsonArr);
        }

        return jsonObj;
    }



}
