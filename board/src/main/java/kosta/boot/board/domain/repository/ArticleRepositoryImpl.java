package kosta.boot.board.domain.repository;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.Board;
import kosta.boot.board.domain.repository.mybatis.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository{

    private final BoardMapper boardMapper;

    @Trace
    @Override
    public int save(Board board){
        return boardMapper.save(board);
    }

    @Trace
    @Override
    public List<Board> findAll(ArticleSearchCondition condition){
        return boardMapper.findAll(null);
    }

    @Override
    public Optional<Board> findByIdx(Long idx) {
        return null;
    }

    @Override
    public int update(int no, Board board) {
        return 0;
    }

    @Override
    public int delete(Long idx) {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

}
