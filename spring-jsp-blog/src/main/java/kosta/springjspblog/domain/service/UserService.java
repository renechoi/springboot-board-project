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
        User savedUser = userRepository.save(user);
        int userNo = savedUser.getUserNo();

        log.info("savedUser userNo ={}", userNo);
    }

    public boolean idCheck(String id) {
        boolean isExist;
        User user = userRepository.findById(id);
        isExist = user != null;
        return isExist;
    }

    public User login(User user) {
        return userRepository.findByObject(user);
    }

    public void unRegister(User user, HttpSession session) {
        User authUser = (User) session.getAttribute("authUser");

        if (!authUser.equals(user)){
            throw new IllegalArgumentException("not authorized user");
        }

        userRepository.delete(user);
        session.removeAttribute("authUser");
    }
}
