package kosta.springjspblog.repository;

import kosta.springjspblog.domain.Article;
import kosta.springjspblog.repository.mybatis.ArticleMapper;
import kosta.springjspblog.repository.mybatis.BlogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ArticleRepository implements JBlogRepository<Article>{

    private final ArticleMapper articleMapper;

    @Override
    public Article save(Article article) {
        return article;
    }

    @Override
    public List<Article> findAll() {
        return null;
    }

    public List<Article> findAll(int userNo, int crtCateNo) {
        articleMapper.findAll(userNo, crtCateNo);
        return null;
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
    public Article update() {
        return null;
    }

    @Override
    public Article delete() {
        return null;
    }
}
