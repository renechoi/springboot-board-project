package kosta.springjspblog.domain.repository.mybatis;

import kosta.springjspblog.domain.dto.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int save(User user);
    List<User> findAll();
    User findById(String id);
    User findByObject(User user);
    void delete(User user);
}
