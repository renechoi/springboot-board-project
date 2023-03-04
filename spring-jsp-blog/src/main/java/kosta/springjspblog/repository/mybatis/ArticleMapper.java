package kosta.springjspblog.repository.mybatis;

import kosta.springjspblog.domain.Article;
import kosta.springjspblog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int save(Article article);
    List<Article> findAll(int userNo, int crtCateNo);
    Article findById(String id);
    Article findByObject(Article article);
}
