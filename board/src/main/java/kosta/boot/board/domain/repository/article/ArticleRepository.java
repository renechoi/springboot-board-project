package kosta.boot.board.domain.repository.article;

import kosta.boot.board.domain.dto.ArticleDto;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    int save(ArticleDto articleDto);
    int update(int no, ArticleDto articleDto);
    int delete(Long idx);
    Optional<ArticleDto> findByIdx(Long idx);
    List<ArticleDto> findAll(ArticleSearchCondition condition);
    int getCount();





}
