package kosta.springjspblog.domain.service;

import kosta.springjspblog.domain.dto.User;
import kosta.springjspblog.domain.repository.UserRepository;
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

    @Transactional
    public void join(User user) {
        User savedUser = userRepository.save(user);
        int userNo = savedUser.getUserNo();
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
