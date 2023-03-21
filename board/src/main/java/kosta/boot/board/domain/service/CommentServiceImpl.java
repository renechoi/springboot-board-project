package kosta.boot.board.domain.service;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.pagination.Pagination;
import kosta.boot.board.domain.repository.comment.CommentRepository;
import kosta.boot.board.domain.repository.comment.CommentRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository ;


    @Override
    public boolean register(CommentDto commentDto) {
        int result = commentRepository.save(commentDto);
        return result == 1;
    }

    @Override
    public boolean delete(Long idx) {
        int result = commentRepository.delete(idx);
        return result == 1;
    }

    @Override
    public CommentDto findByIdx(Long idx) {
        Optional<CommentDto> findArticle = commentRepository.findByIdx(idx);
        return findArticle.orElse(new CommentDto());
    }

    @Override
    public List<CommentDto> findAll(CommentDto commentDto) {
        return commentRepository.findAll(commentDto);
    }

    @Trace
    public int getCount() {
        return commentRepository.getCount();
    }
}
