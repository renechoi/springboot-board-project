package kosta.springjspblog.repository;

import kosta.springjspblog.repository.mybatis.MybatisMapper;
import kosta.springjspblog.domain.Blog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogRepository implements JBlogRepository<Blog>{

    private final MybatisMapper<Blog> mybatisMapper;

    @Override
    public Blog save(Blog blog) {
        return null;
    }

    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(String id) {
        return null;
    }

    @Override
    public Blog findByObject(Blog blog) {
        return null;
    }

    @Override
    public Blog update() {
        return null;
    }

    @Override
    public Blog delete() {
        return null;
    }
}
