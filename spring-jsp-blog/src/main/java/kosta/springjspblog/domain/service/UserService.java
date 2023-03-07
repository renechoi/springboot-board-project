package kosta.springjspblog.domain.service;

import kosta.springjspblog.domain.repository.BlogRepository;
import kosta.springjspblog.domain.repository.CategoryRepository;
import kosta.springjspblog.domain.repository.UserRepository;
import kosta.springjspblog.domain.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final BlogRepository blogRepository;

    private final CategoryRepository categoryRepository;

    /*회원가입: 회원정보, 블로그기본정보, 카테고리기본정보가 저장되어야함*/
    @Transactional
    public void join(User user, HttpSession session) {
        //회원정보 저장
        User savedUser = userRepository.save(user);// 키값 필요
		int userNo = savedUser.getUserNo();

        log.info("savedUser userNo ={}", userNo);
		//블로그 초기값 저장(개설)
//		Blog blog = new Blog();
//		blog.setUserNo(userNo);
//		blog.setBlogTitle(user.getUserName() +"의 블로그입니다.");
//		blog.setLogoFile("default");
//        session.setAttribute("blog", blog);
//
//		blogRepository.save(blog);
//
//		//카테고리 초기값 저장
//		Category category = new Category();
//		category.setCateName("미분류");
//		category.setDescription("기본으로 만들어지는 카테고리 입니다.");
//		category.setUserNo(userNo);
//
//		categoryRepository.save(category);
    }

    public boolean idCheck(String id) {
        boolean isExist;
        User user = userRepository.findById(id);
        isExist = user != null; // 존재하는 경우 true 값 리턴
        return isExist;
    }

    public User login(User user) {
        return userRepository.findByObject(user);
    }
}
