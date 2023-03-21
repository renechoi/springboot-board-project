package kosta.boot.board.domain.repository.comment;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.dto.CommentDto;
import kosta.boot.board.domain.pagination.Pagination;
import kosta.boot.board.domain.repository.article.ArticleRepository;
import kosta.boot.board.domain.repository.mybatis.mapper.ArticleMapper;
import kosta.boot.board.domain.repository.mybatis.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepository{


    private final CommentMapper commentMapper;

    @Override
    public int save(CommentDto commentDto) {
        return commentMapper.save(commentDto);
    }



    @Override
    public int update(int no, CommentDto commentDto) {
        return 0;
    }


    @Trace
    @Override
    public int delete(Long idx) {
        return commentMapper.delete(idx);
    }


    @Trace
    @Override
    public Optional<CommentDto> findByIdx(Long idx) {
        return commentMapper.findByIdx(idx);
    }


    @Override
    public int getCount() {
        return commentMapper.getCount();
    }

    @Trace
    @Override
    public List<CommentDto> findAll(CommentDto commentDto){
        return commentMapper.findAll(commentDto);
    }


}