package kosta.springjspblog.domain;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Data
public class Blog {

	private int userNo;
	private String blogTitle;
	private String logoFile;
	private String id;
	private MultipartFile file;
}
