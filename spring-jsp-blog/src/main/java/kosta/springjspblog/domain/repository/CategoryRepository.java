package kosta.springjspblog.domain.repository;

import kosta.springjspblog.domain.repository.mybatis.CategoryMapper;
import kosta.springjspblog.domain.dto.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CategoryRepository implements JBlogRepository<Category> {

    private final CategoryMapper categoryMapper;

    @Override
    public Category save(Category category) {
        categoryMapper.save(category);
        return category;
    }

    @Override
    public List<Category> findAll() {
        return null;
    }

    public List<Category> findAll(String userId) {

        return categoryMapper.findAll(userId);
    }

    @Override
    public Category findById(String id) {
        return categoryMapper.findById(id);
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
    public int delete(Category category) {
       return categoryMapper.delete(category);
    }

}
