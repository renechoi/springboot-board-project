//package kosta.springjspblog.Service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.javaex.dao.CateDao;
//import com.javaex.vo.CateVo;
//
//@Service
//public class CateService {
//
//	@Autowired
//	private CateDao cateDao;
//
//	/*회원번호로 가테고리 가져오기*/
//	public List<CateVo> getCateList(int userNo) {
//		return cateDao.selectList(userNo);
//	}
//
//
//	/*카테고리 추가*/
//	public CateVo addCate(CateVo cateVo) {
//		//카테고리 내용을 저장하고 방금저장한 카테고리 정보 모두를 가져온다
//		int cateNo = cateDao.insertCate(cateVo);
//		return cateDao.selectCate(cateNo);
//	}
//
//	/*카테고리 삭제*/
//	public int removeCate(int cateNo) {
//		return cateDao.deleteCate(cateNo);
//	}
//}
