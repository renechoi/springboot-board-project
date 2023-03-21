package kosta.boot.board.domain.repository.mybatis.mapper;

import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.pagination.Pagination;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CommentMapper {
    int save(CommentDto CommentDto);
    int update(CommentDto CommentDto);
    int delete(Long idx);
    Optional<CommentDto> findByIdx(Long idx);
    List<CommentDto> findAll(CommentDto commentDto);
    int getCount();
}