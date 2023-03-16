package kosta.boot.board.domain.repository;

import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.repository.mybatis.mapper.ArticleMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@SpringBootTest
class ArticleRepositoryImplTest {


    @Autowired
    private ArticleMapper articleMapper;


    @Test
    public void save() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setTitle("1번 게시글 제목");
        articleDto.setContent("1번 게시글 내용");

        int result = articleMapper.save(articleDto);
        System.out.println("결과는 " + result + "입니다.");
    }

    @Test
    public void saveMultiValues() {
        for (int i = 1; i <= 50; i++) {
            ArticleDto params = new ArticleDto();
            params.setTitle(i + "번 게시글 제목");
            params.setContent(i + "번 게시글 내용");
            articleMapper.save(params);
        }
    }

    @Test
    void findAll() {
        List<ArticleDto> articleDtos = articleMapper.findAll(null);
        System.out.println("boards = " + articleDtos);
    }
}