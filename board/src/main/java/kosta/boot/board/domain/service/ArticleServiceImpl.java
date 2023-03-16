package kosta.boot.board.domain.service;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.repository.article.ArticleRepository;
import kosta.boot.board.domain.repository.article.ArticleSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public boolean register(ArticleDto articleDto) {
        int result = articleRepository.save(articleDto);
        return result == 1;
    }

    @Override
    @Transactional(readOnly = true)
    public ArticleDto findByIdx(Long idx) {
        Optional<ArticleDto> findArticle = articleRepository.findByIdx(idx);
//        return findArticle.orElseThrow(IllegalStateException::new);
        return findArticle.orElse(new ArticleDto());
    }

    @Override
    public boolean delete(Long idx) {
        return false;
    }

    @Trace
    @Override
    @Transactional(readOnly = true)
    public List<ArticleDto> findAll(ArticleSearchCondition condition) {
       return articleRepository.findAll(condition);
    }
}
