package kosta.boot.board.domain.repository;

import kosta.boot.board.domain.dto.Board;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository {

    int save(Board board);
    int update(int no, Board board);
    int delete(Long idx);
    Optional<Board> findByIdx(Long idx);
    List<Board> findAll(ArticleSearchCondition condition);
    int getCount();





}
