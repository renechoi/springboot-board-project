package kosta.springjspblog.domain.service;

import kosta.springjspblog.domain.dto.Blog;
import kosta.springjspblog.domain.dto.SearchCondition;
import kosta.springjspblog.domain.dto.UploadFile;
import kosta.springjspblog.domain.dto.User;
import kosta.springjspblog.domain.repository.BlogRepository;
import kosta.springjspblog.domain.file.FileStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final FileStore fileStore;

    public Blog create(Blog blog, User user) {
        blog.setUserId(user.getId());
        Blog createdBlog = blogRepository.save(blog);
        createdBlog.setUserId(user.getId());
        return createdBlog;
    }

    public Blog getBlog(String id) {
        return blogRepository.findById(id);
    }

    public Blog blogAdminBasicModify(Blog blog, User authUser) throws IOException {
        blog.setUserId(authUser.getId());
        UploadFile attachFile = fileStore.storeFile(blog.getFile());
        blog.setLogoFile(attachFile.getStoreFileName());
        return blogRepository.update(blog);
    }

    public String searchByRequest(SearchCondition searchCondition) {
        String condition = searchCondition.getCondition();
        if (condition.equals("blog-user")) {
          return blogRepository.findById(searchCondition.getKeyword()).getUserId();
        }
        return blogRepository.findByTitle(searchCondition.getKeyword()).getUserId();
    }
}

