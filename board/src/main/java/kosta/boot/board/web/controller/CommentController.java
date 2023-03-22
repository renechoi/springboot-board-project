package kosta.boot.board.web.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import kosta.boot.board.config.adapter.CommentDtoWrapper;
import kosta.boot.board.config.adapter.LocalDateTimeSerializer;
import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
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
    @GetMapping(value = "/{articleIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JsonProcessingException, JsonProcessingException {

        List<CommentDto> comments = commentService.findAll(commentDto);

        ObjectMapper objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer());
        objectMapper.registerModule(module);

        CommentDtoWrapper wrapper = new CommentDtoWrapper();
        wrapper.setComments(comments);

        return objectMapper.writeValueAsString(wrapper);
    }


    @Trace
    @RequestMapping(value = {"", "/{articleIdx}"}, method = {RequestMethod.PATCH, RequestMethod.POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public String registerComment(@RequestBody CommentDto commentDto) {
        return booleanConverter(commentService.register(commentDto));
    }

    @Trace
    @DeleteMapping(value = "/{idx}")
    public String deleteComment(@PathVariable(value = "idx") final Long idx) {
        return booleanConverter(commentService.delete(idx));
    }

    private String booleanConverter(Boolean bool) {
        return bool ? "true" : "false";
    }


//
//    @Trace
//    @GetMapping(value = "/{articleIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public JsonObject getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JSONException {
//
//        List<CommentDto> comments = commentService.findAll(commentDto);
//
//        JsonObject jsonObj = new JsonObject();
//        if (!CollectionUtils.isEmpty(comments)) {
//            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, new GsonLocalDateTimeAdapter()).create();
//            JsonArray jsonArr = gson.toJsonTree(comments).getAsJsonArray();
//            jsonObj.add("comments", jsonArr);
//        }
//        return jsonObj;
//    }

//    @Trace
//    @GetMapping(value = "/{articleIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public JSONObject getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JSONException {
//
//        List<CommentDto> comments = commentService.findAll(commentDto);
//
//        JSONObject jsonObj = new JSONObject();
//        if (!CollectionUtils.isEmpty(comments)) {
//
//            JSONArray commentArr = new JSONArray();
//            for (CommentDto comment : comments) {
//                JSONObject commentObj = new JSONObject();
//
//                commentObj.put("idx", comment.getIdx());
//                commentObj.put("articleIdx", comment.getArticleIdx());
//                commentObj.put("content", comment.getContent());
//                commentObj.put("writer", comment.getWriter());
//                commentObj.put("deleteYn", comment.getDeleteYn());
//                commentObj.put("createdAt", comment.getCreatedAt().toString());
//                commentArr.put(commentObj);
//            }
//            jsonObj.put("comments", commentArr);
//        }
//        return jsonObj;
//    }


//
//    @Trace
//    @GetMapping(value = "/{articleIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public JSONObject getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JSONException {
//
//        List<CommentDto> comments = commentService.findAll(commentDto);
//        JSONObject result = new JSONObject();
//
//        if (!CollectionUtils.isEmpty(comments)) {
//            JSONArray commentsJsonArray = new JSONArray();
//
//            for (CommentDto comment : comments) {
//                JSONObject commentJsonObject = new JSONObject();
//                commentJsonObject.put("idx", comment.getIdx());
//                commentJsonObject.put("articleIdx", comment.getArticleIdx());
//                commentJsonObject.put("content", comment.getContent());
//                commentJsonObject.put("writer", comment.getWriter());
//                commentJsonObject.put("deleteYn", comment.getDeleteYn());
//                commentJsonObject.put("createdAt", comment.getCreatedAt().toString());
//                commentsJsonArray.put(commentJsonObject);
//            }
//
//            result.put("comments", commentsJsonArray);
//        }
//
//        System.out.println("result = " + result);
//        System.out.println("result = " + result.opt("comments"));
//        System.out.println("result = " + result.names());
//        return result;
//    }

//
//    @GetMapping(value = "/{articleIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public Map<String, Object> getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JSONException {
//
//        List<CommentDto> comments = commentService.findAll(commentDto);
//        Map<String, Object> result = new HashMap<>();
//
//        if (!CollectionUtils.isEmpty(comments)) {
//            JSONArray commentsJsonArray = new JSONArray();
//
//            for (CommentDto comment : comments) {
//                JSONObject commentJsonObject = new JSONObject();
//                commentJsonObject.put("idx", comment.getIdx());
//                commentJsonObject.put("articleIdx", comment.getArticleIdx());
//                commentJsonObject.put("content", comment.getContent());
//                commentJsonObject.put("writer", comment.getWriter());
//                commentJsonObject.put("deleteYn", comment.getDeleteYn());
//                commentJsonObject.put("createdAt", comment.getCreatedAt().toString());
//                commentsJsonArray.put(commentJsonObject);
//            }
//
//            result.put("comments", commentsJsonArray);
//        }
//
//        System.out.println("result = " + result);
//        System.out.println("result = " + result.get("comments"));
//        System.out.println("result = " + result.keySet());
//        return result;
//    }
//

//
//
//
//    @GetMapping(value = "/{articleIdx}")
//    public String getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JSONException {
//
//        List<CommentDto> comments = commentService.findAll(commentDto);
//        Map<String, Object> result = new HashMap<>();
//
//        if (!CollectionUtils.isEmpty(comments)) {
//            JSONArray commentsJsonArray = new JSONArray();
//
//            for (CommentDto comment : comments) {
//                JSONObject commentJsonObject = new JSONObject();
//                commentJsonObject.put("idx", comment.getIdx());
//                commentJsonObject.put("articleIdx", comment.getArticleIdx());
//                commentJsonObject.put("content", comment.getContent());
//                commentJsonObject.put("writer", comment.getWriter());
//                commentJsonObject.put("deleteYn", comment.getDeleteYn());
//                commentJsonObject.put("createdAt", comment.getCreatedAt().toString());
//                commentsJsonArray.put(commentJsonObject);
//            }
//
//            result.put("comments", commentsJsonArray);
//        }
//
//        System.out.println("result = " + result);
//        System.out.println("result = " + result.get("comments"));
//        System.out.println("result = " + result.keySet());
//
//        Gson gson = new Gson();
//        String json = gson.toJson(result);
//        System.out.println(json);
//
//
//        return json;
//    }
//


//
//    @Trace
//    @GetMapping(value = "/{articleIdx}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<JSONObject> getComments(@PathVariable("articleIdx") Long articleIdx, @ModelAttribute("CommentDto") CommentDto commentDto) throws JSONException {
//
//        List<CommentDto> comments = commentService.findAll(commentDto);
//        JSONObject result = new JSONObject();
//
//        if (!CollectionUtils.isEmpty(comments)) {
//            JSONArray commentsJsonArray = new JSONArray();
//
//            for (CommentDto comment : comments) {
//                JSONObject commentJsonObject = new JSONObject();
//                commentJsonObject.put("idx", comment.getIdx());
//                commentJsonObject.put("articleIdx", comment.getArticleIdx());
//                commentJsonObject.put("content", comment.getContent());
//                commentJsonObject.put("writer", comment.getWriter());
//                commentJsonObject.put("deleteYn", comment.getDeleteYn());
//                commentJsonObject.put("createdAt", comment.getCreatedAt().toString());
//                commentsJsonArray.put(commentJsonObject);
//            }
//
//            result.put("comments", commentsJsonArray);
//        }
//
//        System.out.println("result = " + result);
//        return ResponseEntity.ok().body(result);
//    }


}
