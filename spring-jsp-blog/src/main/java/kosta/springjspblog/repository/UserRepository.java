package kosta.springjspblog.repository;

import kosta.springjspblog.repository.mybatis.MybatisMapper;
import kosta.springjspblog.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository implements JBlogRepository<User> {

    private final MybatisMapper<User> mybatisMapper;


    public User save(User user) {
        mybatisMapper.save(user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        mybatisMapper.findById(id);
        return null;
    }

    @Override
    public User findByObject(User user) {
        return mybatisMapper.findByObject(user);
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
