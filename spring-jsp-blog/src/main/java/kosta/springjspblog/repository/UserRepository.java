package kosta.springjspblog.repository;

import kosta.springjspblog.repository.mybatis.UserMapper;
import kosta.springjspblog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository implements JBlogRepository<User> {

    private final UserMapper userMapper;

    public User save(User user) {
        userMapper.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(String id) {
        return userMapper.findById(id);
    }

    @Override
    public User findByObject(User user) {
        return userMapper.findByObject(user);
    }

    @Override
    public User update() {
        return null;
    }

    @Override
    public User delete() {
        return null;
    }


}
