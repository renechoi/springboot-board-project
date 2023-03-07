package kosta.springjspblog.repository.mybatis;

import kosta.springjspblog.domain.Article;
import kosta.springjspblog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int save(Article article);
    List<Article> findAll(String userId, int categoryNo);
    Article findById(String id);
    Article findByObject(Article article);
}
