package kosta.springjspblog.domain.repository;

import kosta.springjspblog.domain.dto.Blog;
import kosta.springjspblog.domain.repository.mybatis.BlogMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogRepository implements JBlogRepository<Blog> {

    private final BlogMapper blogMapper;

    @Override
    public Blog save(Blog blog) {
        blogMapper.save(blog);
        return blog;
    }

    @Override
    public List<Blog> findAll() {
        return null;
    }

    @Override
    public Blog findById(String id) {
        return blogMapper.findById(id);
    }

    @Override
    public Blog findByObject(Blog blog) {
        return null;
    }

    @Override
    public Blog update(Blog blog) {
       return blogMapper.update(blog);
    }


    @Override
    public int delete(Blog blog) {
        return 0;
    }
}
