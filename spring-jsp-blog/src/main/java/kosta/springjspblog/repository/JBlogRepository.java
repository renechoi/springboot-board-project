package kosta.springjspblog.repository;

import java.util.List;

public interface JBlogRepository<T> {
    T save(T t);
    List<T> findAll();
    T findById(int id);
    T findByObject(T t);
    T update();
    T delete();
}
