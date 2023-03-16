package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.Board;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ArticleService {
    public boolean register(Board params);
    public Board findByIdx(Long idx);
    public boolean delete(Long idx);
    public List<Board> findByAll(Board params);
}
