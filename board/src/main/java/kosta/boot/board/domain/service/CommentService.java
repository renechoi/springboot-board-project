package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.pagination.Pagination;
import kosta.boot.board.domain.repository.article.ArticleRepository;

import java.util.List;

public interface CommentService {



    boolean register(CommentDto commentDto);
    boolean delete(Long idx);
    CommentDto findByIdx(Long idx);
    List<CommentDto> findAll(CommentDto commentDto);
}
