package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.ArticleDto;

import java.util.List;

public interface ArticleService {
    boolean register(ArticleDto articleDto);
    ArticleDto findByIdx(Long idx);
    boolean delete(Long idx);
    List<ArticleDto> findAll(ArticleDto articleDto);
}
