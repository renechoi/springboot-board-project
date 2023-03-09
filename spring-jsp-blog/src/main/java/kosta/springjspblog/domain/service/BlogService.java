package kosta.springjspblog.domain.service;

import kosta.springjspblog.domain.dto.Blog;
import kosta.springjspblog.domain.dto.UploadFile;
import kosta.springjspblog.domain.repository.BlogRepository;
import kosta.springjspblog.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class BlogService {

	private final BlogRepository blogRepository;

    public Blog create(Blog blog){
        return blogRepository.save(blog);
    }

	/*블로그정보가져오기*/
	public Blog getBlog(String id) {
		return blogRepository.findById(id);
	}

	/*블로그 기본설정페이지 수정*/
	public Blog blogAdminBasicModify(Blog blog) {
		MultipartFile file = blog.getFile();

		//첨부파일이 있으면 첨부파일 관련 정보 추출
		if ( !file.isEmpty()) {
			FileUtil fileUtil = new FileUtil();
			UploadFile uploadFile = fileUtil.fileUpload(file);
			//수정될 개인블로그 logo 파일 정보를  blogVo에 저장
			blog.setLogoFile(uploadFile.getSaveName());
		}

    //블로그 기본설정내용 수정
		return blogRepository.update(blog);
	}

}