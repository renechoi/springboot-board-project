//package kosta.springjspblog.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.javaex.dao.PostDao;
//import com.javaex.vo.PostVo;
//
//@Service
//public class PostService {
//
//	@Autowired
//	private PostDao postDao;
//
//	/*포스트 글저장*/
//	public int postWrite(PostVo postVo) {
//		return postDao.insertPost(postVo);
//	}
//
//	/*특정 회원의 선택한 카테고리의 포스트 리스트 가져오기*/
//	public List<PostVo> getPostList(int userNo, int crtCateNo) {
//		return postDao.selectList(userNo, crtCateNo);
//	}
//
//	/*선택한 포스트 가져오기*/
//	public PostVo getPost(int postNo) {
//		return postDao.selectPost(postNo);
//	}
//}
