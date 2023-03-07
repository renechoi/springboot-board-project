package kosta.springjspblog.domain.dto;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
@Data
public class Blog {

	private String userId;
	private String blogTitle;
	private String logoFile;
	private MultipartFile file;
}
