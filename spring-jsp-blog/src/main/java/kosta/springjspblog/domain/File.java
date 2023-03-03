package kosta.springjspblog.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class File {
	
	private String orgName;
	private String exName;
	private String saveName;
	private String filePath;
	private long fileSize;

}
