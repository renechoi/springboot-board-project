package kosta.boot.board.domain.repository.comment;

import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.pagination.Pagination;

import java.util.List;
import java.util.Optional;

public interface CommentRepository {

    int save(CommentDto commentDto);
    int update(int no, CommentDto commentDto);
    int delete(Long idx);
    Optional<CommentDto> findByIdx(Long idx);
    List<CommentDto> findAll(CommentDto commentDto);
    int getCount();





}
