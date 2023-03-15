package kosta.boot.board.domain.repository;

import kosta.boot.board.domain.dto.Board;
import kosta.boot.board.domain.repository.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper boardMapper;

    public Board save(Board board){
        int save = boardMapper.save(board);
        return board;
    }

}
