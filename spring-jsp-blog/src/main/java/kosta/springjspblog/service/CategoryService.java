package kosta.springjspblog.service;

import java.util.List;

import kosta.springjspblog.domain.Category;
import kosta.springjspblog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryService {

	private CategoryRepository categoryRepository;

	/*회원번호로 가테고리 가져오기*/
	public List<Category> getCategories(int userNo) {
		return categoryRepository.findAll(userNo);
	}

//
//	/*카테고리 추가*/
//	public CateVo addCate(CateVo cateVo) {
//		//카테고리 내용을 저장하고 방금저장한 카테고리 정보 모두를 가져온다
//		int cateNo = cateDao.insertCate(cateVo);
//		return cateDao.selectCate(cateNo);
//	}
//
//	/*카테고리 삭제*/
//	public int removeCate(int cateNo) {
//		return cateDao.deleteCate(cateNo);
//	}
}
