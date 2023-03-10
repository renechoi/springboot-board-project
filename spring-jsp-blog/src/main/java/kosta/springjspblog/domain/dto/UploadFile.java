package kosta.springjspblog.domain.dto;


import lombok.Data;

@Data
public class UploadFile {
	
	private  String orgName;
	private  String exName;
	private  String saveName;
	private  String filePath;
	private  long fileSize;

	private String uploadFileName;
	private String storeFileName;


	public UploadFile(String uploadFileName, String storeFileName) {
		this.uploadFileName = uploadFileName;
		this.storeFileName = storeFileName;
	}

	public UploadFile(String orgName, String exName, String saveName, String filePath, long fileSize) {
		this.orgName = orgName;
		this.exName = exName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}
}
