package kosta.springjspblog.service;

import kosta.springjspblog.domain.Blog;
import kosta.springjspblog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


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

//	/*블로그 기본설정페이지 수정*/
//	public int blogAdminBasicModify(BlogVo blogVo) {
//
//		MultipartFile file = blogVo.getFile();
//		FileVo fileVo ;
//
//		//첨부파일이 있으면 첨부파일 관련 정보 추출
//		if ( !file.isEmpty()) {
//			FileUtil fileUtil = new FileUtil();
//			fileVo = fileUtil.fileUpload(file);
//			//수정될 개인블로그 logo 파일 정보를  blogVo에 저장
//			blogVo.setLogoFile(fileVo.getSaveName());
//		}
//
//    //블로그 기본설정내용 수정
//		return blogRepository.updateBlog(blogVo);
//	}

}
