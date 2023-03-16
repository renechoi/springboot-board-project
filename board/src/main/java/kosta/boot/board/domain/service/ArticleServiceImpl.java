package kosta.boot.board.domain.service;

import kosta.boot.board.domain.dto.Board;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{
    @Override
    public boolean register(Board params) {
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public Board findByIdx(Long idx) {
        return null;
    }

    @Override
    public boolean delete(Long idx) {
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Board> findByAll(Board params) {
        return null;
    }
}
