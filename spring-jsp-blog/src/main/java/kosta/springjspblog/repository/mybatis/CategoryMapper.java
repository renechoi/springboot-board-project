package kosta.springjspblog.repository.mybatis;

import kosta.springjspblog.domain.Blog;
import kosta.springjspblog.domain.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int save(Category category);
    List<Category> findAll(String userId);
    Category findById(String id);
    Category findByObject(Category category);
}
