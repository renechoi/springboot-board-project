package kosta.springjspblog.domain.dto;


public class UploadFile {
	
	private  String orgName;
	private  String exName;
	private  String saveName;
	private  String filePath;
	private  long fileSize;

	public UploadFile(String orgName, String exName, String saveName, String filePath, long fileSize) {
		this.orgName = orgName;
		this.exName = exName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.fileSize = fileSize;
	}

	public String getOrgName() {
		return orgName;
	}

	public String getExName() {
		return exName;
	}

	public String getSaveName() {
		return saveName;
	}

	public String getFilePath() {
		return filePath;
	}

	public long getFileSize() {
		return fileSize;
	}


	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}
}
