package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.repository.article.ArticleSearchCondition;

import java.util.List;

public interface ArticleService {
    boolean register(ArticleDto articleDto);
    ArticleDto findByIdx(Long idx);
    boolean delete(Long idx);
    List<ArticleDto> findAll(ArticleSearchCondition condition);
}
