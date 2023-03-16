package kosta.boot.board.domain.repository.mybatis.mapper;

import kosta.boot.board.domain.dto.Board;
import kosta.boot.board.domain.repository.ArticleSearchCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface BoardMapper {

     int save(Board board);
     int update(@Param("no") int no, @Param("updateParam") Board board);
     int delete(Long idx);
     Optional<Board> findByIdx(Long idx);
     List<Board> findAll(ArticleSearchCondition condition);
     int getCount();

}