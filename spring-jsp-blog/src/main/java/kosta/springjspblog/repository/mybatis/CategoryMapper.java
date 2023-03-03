package kosta.springjspblog.repository.mybatis;

import kosta.springjspblog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryMapper {

    int save(Blog blog);
    List<Blog> findAll();
    Blog findById(String id);
    Blog findByObject(Blog blog);
}
