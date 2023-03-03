package kosta.springjspblog.service;

import kosta.springjspblog.repository.BlogRepository;
import kosta.springjspblog.repository.CategoryRepository;
import kosta.springjspblog.repository.UserRepository;
import kosta.springjspblog.domain.Blog;
import kosta.springjspblog.domain.Category;
import kosta.springjspblog.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	/*회원가입: 회원정보, 블로그기본정보, 카테고리기본정보가 저장되어야함*/
	@Transactional
	public void join(User user) {
		//회원정보 저장
		userRepository.save(user);// 키값 필요
//		int userNo = savedUser.getUserNo();

//		System.out.println("userNo = " + userNo);
//		//블로그 초기값 저장(개설)
//		Blog blogVo = new Blog();
//		blogVo.setUserNo(userNo);
//		blogVo.setBlogTitle(user.getUserName() +"의 블로그입니다.");
//		blogVo.setLogoFile("default");
//
//		blogRepository.save(blogVo);
//
//		//카테고리 초기값 저장
//		Category category = new Category();
//		category.setCateName("미분류");
//		category.setDescription("기본으로 만들어지는 카테고리 입니다.");
//		category.setUserNo(userNo);
//
//		categoryRepository.save(category);
	}


//	/*아이디체크 : 회원가입시 사용중인 아이디인지 검사*/
//	public boolean idCheck(String id) {
//		boolean isExist;
//		UserVo userVo = userDao.selectUserVo(id);
//		if(userVo == null) {
//			isExist = false; //존재하니-->아니요: 사용할 수 있음
//		} else {
//			isExist = true;  //존재하니-->예: 사용할 수 없음
//		}
//		return isExist;
//	}

	/*로그인*/
	public User login(User user) {
		//회원정보 가져오기
		return userRepository.findByObject(user);
	}
}
