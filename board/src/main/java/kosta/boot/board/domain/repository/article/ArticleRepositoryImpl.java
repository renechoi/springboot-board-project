package kosta.boot.board.domain.repository.article;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.pagination.ArticleSearchCondition;
import kosta.boot.board.domain.pagination.Pagination;
import kosta.boot.board.domain.repository.mybatis.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository{

    private final ArticleMapper articleMapper;

    @Trace
    @Override
    public int save(ArticleDto articleDto){
        return articleMapper.save(articleDto);
    }


    @Trace
    @Override
    public Optional<ArticleDto> findByIdx(Long idx) {
        return articleMapper.findByIdx(idx);
    }

    @Trace
    @Override
    public int update(int no, ArticleDto articleDto) {
        return 0;
    }

    @Trace
    @Override
    public int delete(Long idx) {
        return articleMapper.delete(idx);
    }

    @Override
    public int getCount() {
        return articleMapper.getCount();
    }

    @Trace
    @Override
    public List<ArticleDto> findAll(Pagination pagination){
        return articleMapper.findAll(null);
    }


}
