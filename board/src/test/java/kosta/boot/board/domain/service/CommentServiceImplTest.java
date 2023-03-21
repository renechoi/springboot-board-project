package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.CommentDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class CommentServiceImplTest {

    @Autowired
    private CommentService commentService;


    @Test
    public void registerComments() {
        int number = 20;
        for (int i = 1; i <= number; i++) {
            CommentDto params = new CommentDto();
            params.setArticleIdx((long) 51); // 댓글을 추가할 게시글 번호
            params.setContent(i + "번 댓글을 추가합니다!");
            params.setWriter(i + "번 회원");
            commentService.register(params);
        }
        log.info("[테스트] =  " + "댓글 " + number + "개가 등록되었습니다.");
    }
}