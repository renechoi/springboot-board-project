package kosta.springjspblog.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class UploadFile {
	
	private String orgName;
	private String exName;
	private String saveName;
	private String filePath;
	private long fileSize;

}
