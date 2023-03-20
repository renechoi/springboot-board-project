package kosta.boot.board.domain.service;

import kosta.boot.board.config.annotation.Trace;
import kosta.boot.board.domain.dto.ArticleDto;
import kosta.boot.board.domain.pagination.Pagination;
import kosta.boot.board.domain.repository.article.ArticleRepository;
import kosta.boot.board.domain.pagination.ArticleSearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
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
        int result = articleRepository.delete(idx);
        return result == 1;
    }

    @Trace
    @Override
    @Transactional(readOnly = true)
    public List<ArticleDto> findAll(Pagination pagination) {
        pagination.setTotalArticleCount(getCount());
        return articleRepository.findAll(pagination);
    }


    @Trace
    public int getCount() {

        int count = articleRepository.getCount();
        System.out.println("count = " + count);
        return count;
    }
}
