package kosta.springjspblog.service;

import java.util.List;

import kosta.springjspblog.domain.Category;
import kosta.springjspblog.domain.User;
import kosta.springjspblog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    /*회원번호로 가테고리 가져오기*/
    public List<Category> getCategories(String userId) {
        return categoryRepository.findAll(userId);
    }

    /*카테고리 추가*/
    public Category add(Category category) {
        //카테고리 내용을 저장하고 방금저장한 카테고리 정보 모두를 가져온다
        return categoryRepository.save(category);
    }

	/*카테고리 삭제*/
	public int delete(int cateNo) {
        categoryRepository.delete(cateNo);
        return 0;
	}
}
