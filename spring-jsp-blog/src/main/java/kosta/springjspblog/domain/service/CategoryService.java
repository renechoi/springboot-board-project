package kosta.springjspblog.domain.service;

import java.util.List;

import kosta.springjspblog.domain.dto.Category;
import kosta.springjspblog.domain.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getCategories(String userId) {
        return categoryRepository.findAll(userId);
    }

    public Category add(Category category) {
        return categoryRepository.save(category);
    }

	public int delete(Category category) {
       return categoryRepository.delete(category);
	}
}
