package kosta.boot.board.domain.repository;

import kosta.boot.board.domain.dto.Board;
import kosta.boot.board.domain.repository.mybatis.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@SpringBootTest
class ArticleRepositoryImplTest {


    @Autowired
    private BoardMapper boardMapper;


    @Test
    public void save() {
        Board board = new Board();
        board.setTitle("1번 게시글 제목");
        board.setContent("1번 게시글 내용");

        int result = boardMapper.save(board);
        System.out.println("결과는 " + result + "입니다.");
    }

    @Test
    public void saveMultiValues() {
        for (int i = 2; i <= 50; i++) {
            Board params = new Board();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
            boardMapper.save(params);
        }
    }

    @Test
    void findByAll() {
        List<Board> boards = boardMapper.findByAll();
        System.out.println("boards = " + boards);
    }
}