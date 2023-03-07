package kosta.springjspblog.domain.repository.mybatis;

import kosta.springjspblog.domain.dto.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper {

    int save(Article article);
    List<Article> findAll(String userId, int categoryNo);
    Article findById(String id);
    Article findByObject(Article article);
}
