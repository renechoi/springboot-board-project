package kosta.springjspblog.domain.repository;

import java.util.List;

public interface JBlogRepository<T> {
    T save(T t);
    List<T> findAll();
    T findById(String id);
    T findByObject(T t);
    T update(T t);
    void delete(T t);
}
