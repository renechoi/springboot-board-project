package kosta.springjspblog.repository;

import kosta.springjspblog.repository.mybatis.CategoryMapper;
import kosta.springjspblog.repository.mybatis.UserMapper;
import kosta.springjspblog.domain.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository implements JBlogRepository<Category> {

    private final CategoryMapper categoryMapper;

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(String id) {
        return null;
    }

    @Override
    public Category findByObject(Category category) {
        return null;
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category delete() {
        return null;
    }
}
