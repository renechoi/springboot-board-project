package kosta.springjspblog.domain.service;

import kosta.springjspblog.domain.dto.Blog;
import kosta.springjspblog.domain.dto.UploadFile;
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

    public Blog create(Blog blog) {
        return blogRepository.save(blog);
    }

    public Blog getBlog(String id) {
        return blogRepository.findById(id);
    }

    public Blog blogAdminBasicModify(Blog blog) throws IOException {
        UploadFile attachFile = fileStore.storeFile(blog.getFile());
        blog.setLogoFile(attachFile.getStoreFileName());
        return blogRepository.update(blog);
    }

}


