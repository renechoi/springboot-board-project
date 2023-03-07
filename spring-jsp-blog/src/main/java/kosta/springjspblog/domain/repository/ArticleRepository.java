package kosta.springjspblog.domain.repository;

import kosta.springjspblog.domain.dto.Article;
import kosta.springjspblog.domain.repository.mybatis.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository implements JBlogRepository<Article>{

    private final ArticleMapper articleMapper;

    @Override
    public Article save(Article article) {
        articleMapper.save(article);
        return article;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    public List<Article> findAll(String userId, int categoryNo) {
        return articleMapper.findAll(userId, categoryNo);
    }

    @Override
    public Article findById(String id) {
        return articleMapper.findById(id);
    }

    @Override
    public Article findByObject(Article article) {
        return null;
    }

    @Override
    public Article update(Article article) {
        return null;
    }

    @Override
    public Article delete() {
        return null;
    }
}
