package kosta.springjspblog.util;

import kosta.springjspblog.domain.dto.UploadFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

public class FileUtil {

	public UploadFile fileUpload(MultipartFile file) {
		
	  //String saveDir = "D:\\javaStudy\\upload";
	  String saveDir = "/Users/Rene/Documents/rene/Kosta/spring-jsp-blog/src/main/resources/upload";

		// 원파일이름
		String orgName = file.getOriginalFilename();

		// 확장자
		String exName = orgName.substring(orgName.lastIndexOf("."));

		// 저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;

		//파일패스 생성
		String filePath = saveDir + "\\" + saveName;
		
		//파일 사이즈
		long fileSize = file.getSize();
		
		
		// 파일업로드
		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(saveDir + "/" + saveName);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);

			if (bout != null) {
				bout.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


		return new UploadFile(orgName, exName, saveName, filePath, fileSize);
		

	}







}
