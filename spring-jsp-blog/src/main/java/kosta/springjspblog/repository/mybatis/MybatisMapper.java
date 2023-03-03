package kosta.springjspblog.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisMapper<T> {

    int save(T t);
    List<T> findAll();
    T findById(int id);
    T findByObject(T t);
    T update();
    T delete();
}
