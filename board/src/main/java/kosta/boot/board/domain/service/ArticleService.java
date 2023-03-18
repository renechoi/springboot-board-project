package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.pagination.ArticleSearchCondition;
import kosta.boot.board.domain.pagination.Pagination;

import java.util.List;

public interface ArticleService {
    boolean register(ArticleDto articleDto);
    boolean delete(Long idx);
    ArticleDto findByIdx(Long idx);
    List<ArticleDto> findAll(Pagination pagination);
}
